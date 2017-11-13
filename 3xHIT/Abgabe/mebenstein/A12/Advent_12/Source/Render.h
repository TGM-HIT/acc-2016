#pragma once
#define _CRT_SECURE_NO_WARNINGS
#include "Shader.h"
#include <vector>
#include <functional>
#include <map>


using namespace std;

class Render {

private:

	Shader s;
	vector<GLfloat> vertices, texVertices,nVertices;
	map<char*, GLint> uniformLocs;
	GLuint VAO, VBO;
	GLfloat* fdata;
	

public:

	static int loc;

	Render(Shader s, char* objLoc, vector<char*> uniforms) :
		s(s)
	{
		
		loadObj(objLoc, &vertices, &texVertices, &nVertices);

		cout << "Loaded object with " << vertices.size() << " vertices " << '\n';

		for (char* string : uniforms) {
			uniformLocs[string] = (glGetUniformLocation(s.Program, string));
		}

		if (vertices.size() == 0) {
			cout << "Error loading data" << '\n';
			return;
		}

		
		if (texVertices.size() == 0)
			bufferData({ 3,3 }, { vertices,nVertices });
		else
			bufferData({ 3,2 }, { vertices,texVertices });

	
	};



	void bufferData(vector<int>cols, vector<vector<GLfloat>> dataset) {
		
		vector<GLfloat> data;
		data.clear();

		int* pos = new int[dataset.size()]{};

		bool run = true;

		if (dataset.size() == 1) {
			data = dataset[0];
			run = false;
		}


		while (run)
			for (int i = 0; i < dataset.size(); ++i) 
				for (int j = 0; j < cols[i]; ++j) {
					if (pos[i] >= dataset[i].size()) {
						run = false;
						i = dataset.size();
						break;
					}
					data.push_back(dataset[i][pos[i]++]);
				}
					
		delete[] pos;
		


		glGenVertexArrays(1, &VAO);
		glGenBuffers(1, &VBO);

		cout << data.size()<<'\n';
	
		fdata = data.data();

		bind();

		glBindBuffer(GL_ARRAY_BUFFER, VBO);
		glBufferData(GL_ARRAY_BUFFER, data.size()*sizeof(GLfloat), fdata, GL_STATIC_DRAW);

		int stride = 0;
		int sum = 0;
		for (int i : cols)
			sum += i;

		for (int i = 0; i < dataset.size(); ++i) {
			cout << loc << ' ' << cols[i] << ' ' <<sum<< ' ' << stride<<'\n';
			glVertexAttribPointer(loc, cols[i], GL_FLOAT, GL_FALSE, sum * sizeof(GLfloat), (GLvoid*)(stride*sizeof(GLfloat)));
			glEnableVertexAttribArray(loc++);
			stride += cols[i];
		}

		unbind();
	}


	void render(std::function<void()>lambda = 0) {
		use();
		bind();

		if(lambda != 0)
		lambda();

		draw();

		unbind();
	}

	void renderManuel(std::function<void()> lambda = 0) {
		use();
		bind();
		lambda();
		unbind();
	}

	void draw() {
		int tri = vertices.size() / 3;

		glDrawArrays(GL_TRIANGLES, 0,tri);
	}

	void use() {
		s.Use();
	}

	void bind() {
		glBindVertexArray(VAO);
	}

	void unbind() {
		glBindVertexArray(0);

	}

	void uniform(char* uniform,std::function<void(GLuint)> lambda = 0){
		
		lambda(uniformLocs[uniform]);
	
	}

	~Render() {
		
		glDeleteVertexArrays(1, &VAO);
		glDeleteBuffers(1, &VBO);
		cout << "Deallocated vertex objects" << '\n';
	}

	GLint operator[](char* key) {
		return uniformLocs[key];
	}

private:

	void loadObj(char* f, vector<GLfloat>* vertecies, vector<GLfloat>* textCoord, vector<GLfloat>* nVecs) {
		FILE* file = fopen(f, "r");
		if (file == nullptr)return;

		vector<GLfloat> vecBuffer, nBuffer;

		int res = 0;

		while (res != EOF) {
			char lineHeader[128];

			res = fscanf(file, "%s", lineHeader);

			GLfloat x, y, z;
			if (strcmp(lineHeader, "v") == 0) {

				fscanf(file, "%f %f %f\n", &x, &y, &z);
				vertecies->push_back(x);
				vertecies->push_back(y);
				vertecies->push_back(z);
			}
			else if (strcmp(lineHeader, "vt") == 0) {

				fscanf(file, "%f %f\n", &x, &y);
				textCoord->push_back(x);
				textCoord->push_back(y);
			}
			else if (strcmp(lineHeader, "vn") == 0) {

				fscanf(file, "%f %f %f\n", &x, &y, &z);
				nVecs->push_back(x);
				nVecs->push_back(y);
				nVecs->push_back(z);
			}
			else if (strcmp(lineHeader, "f") == 0) {
				std::string vertex1, vertex2, vertex3;
				unsigned int vertexIndex[3],  normalIndex[3];
				fscanf(file, "%d//%d %d//%d %d//%d\n", &vertexIndex[0], &normalIndex[0], &vertexIndex[1],&normalIndex[1], &vertexIndex[2], &normalIndex[2]);
		
				if ((vertexIndex[0] - 1) < vertecies->size()&& (normalIndex[0] - 1) < nVecs->size()) {
				
					for (int i = 0; i < 3; ++i)
						vecBuffer.push_back((vertecies->at((vertexIndex[0] - 1) * 3 + i)));
					for (int i = 0; i < 3; ++i)
						vecBuffer.push_back((vertecies->at((vertexIndex[1] - 1) * 3 + i)));
					for (int i = 0; i < 3; ++i)
						vecBuffer.push_back((vertecies->at((vertexIndex[2] - 1) * 3 + i)));
				
			/*	fVals.push_back(uvIndex[0]);
				fVals.push_back(uvIndex[1]);
				fVals.push_back(uvIndex[2]);*/
				
					for (int i = 0; i < 3; ++i)
						nBuffer.push_back((nVecs->at((normalIndex[0] - 1) * 3 + i)));
					for (int i = 0; i < 3; ++i)
						nBuffer.push_back((nVecs->at((normalIndex[1] - 1) * 3 + i)));
					for (int i = 0; i < 3; ++i)
						nBuffer.push_back((nVecs->at((normalIndex[2] - 1) * 3 + i)));
				}
			}
			else {
				char stupidBuffer[1000];
				fgets(stupidBuffer, 1000, file);
			}

		}

		if (vecBuffer.size() != 0) {
		
			

			cout << vecBuffer.size();

			vertecies->clear();

			for (GLfloat f : vecBuffer)
				vertecies->push_back(f);

			nVecs->clear();
		
			for (GLfloat f : nBuffer) 
				nVecs->push_back(f);
				

		}
	}
};