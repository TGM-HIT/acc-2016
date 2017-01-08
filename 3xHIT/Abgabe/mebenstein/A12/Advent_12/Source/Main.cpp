#define GLFW_STATIC
#define _CRT_SECURE_NO_WARNINGS
#include <GL\glew.h>
#include <GLFW\glfw3.h>
#include <SOIL.h>
#include <iostream>

#include <glm.hpp>
#include <gtc/matrix_transform.hpp>
#include <gtc\type_ptr.hpp>

#include <opencv2/objdetect/objdetect.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>

#include <vector>

#include "Camera.h"
#include "Shader.h"
#include "Render.h"



using namespace cv;
using namespace std;

GLuint screenWidth = 1980, screenHeight = 1080;


void key_callback(GLFWwindow* window, int key, int scancode, int action, int mode);
void scroll_callback(GLFWwindow* window, double xoffset, double yoffset);
void mouse_callback(GLFWwindow* window, double xpos, double ypos);
void Do_Movement();

void detectEye(Mat img, Mat &output, Rect &r);
void trackEye(Mat img, Mat &output, Rect &r);


Camera camera(glm::vec3(0.0f, 2.0f, 6.0f));
bool keys[1024];
GLfloat lastX = 400, lastY = 300;
bool firstMouse = true;

GLfloat deltaTime = 0.0f;
GLfloat lastFrame = 0.0f;

glm::vec3 lightPos(10.0f, 100.0f, 0.0f);

CascadeClassifier face_cascade, eye_cascade;

Rect eyeR,standart;

int Render::loc = 0;

Mat frame, eye, dst;
bool cam = false;

int main()
{



	face_cascade.load("haarcascade_frontalface_default.xml");
	eye_cascade.load("haarcascade_eye.xml");

	VideoCapture cap(0);

	// Init GLFW
	glfwInit();
	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
	glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);

	GLFWwindow* window = glfwCreateWindow(screenWidth, screenHeight, "OpenGL", NULL, NULL); // Windowed
	glfwMakeContextCurrent(window);

	// Set callbacks
	glfwSetCursorPos(window, (screenWidth / 2), (screenHeight / 2));
	glfwSetKeyCallback(window, key_callback);
	glfwSetCursorPosCallback(window, mouse_callback);
	glfwSetScrollCallback(window, scroll_callback);

	// Options
	glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);

	glewExperimental = GL_TRUE;
	glewInit();


	glViewport(0, 0, screenWidth, screenHeight);

	// OpenGL Options
	glEnable(GL_DEPTH_TEST);
	glEnable(GL_LIGHT0);
	glEnable(GL_LIGHTING);


	//Lightshader and render class
	Shader lightShader("lightShader.vert", "lightShader.frag");
	Render lightRender(lightShader, "cube.obj", { "projection","model","view","tex" });

	//Objectshader and render class
	Shader shader("shader.vert","shader.frag");
	Render render(shader, "NTree.obj", { "projection","model","view","lightPos","lightColor","viewPos" });

	Shader boxShader("box.vert", "box.frag");
	Render boxRender(boxShader, "cube.obj", { "projection","model","view","tex" });

	//Set position of objects.
	//Did 10 trees on the same place because there where troubles loading the texture correctly
	vector<glm::vec3> cubePositions;
	cubePositions.push_back(glm::vec3(10.0f, 0.0f, 0.0f));
	cubePositions.push_back(glm::vec3(10.0f, 0.0f, 5.0f));
	cubePositions.push_back(glm::vec3(-10.0f, 0.0f, 2.0f));
	cubePositions.push_back(glm::vec3(-3.0f, 0.0f, 8.0f));
	cubePositions.push_back(glm::vec3(7.0f, 0.0f, -2.0f));
	cubePositions.push_back(glm::vec3(-8.0f, 0.0f, 3.0f));
	cubePositions.push_back(glm::vec3(2.0f, 0.0f, -8.0f));
	cubePositions.push_back(glm::vec3(0.0f, 0.0f, 7.0f));
	cubePositions.push_back(glm::vec3(6.0f, 0.0f, 3.0f));


	//Setting up everything for the texture
	GLuint texture, boxTexture;
	
	glGenTextures(1, &texture);
	glBindTexture(GL_TEXTURE_2D, texture); 
	
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
	
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);


	Mat tgm_logo = imread("tgm_logo.jpg");
	glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, tgm_logo.cols, tgm_logo.rows, 0, GL_RGB, GL_UNSIGNED_BYTE, tgm_logo.data);
	glGenerateMipmap(GL_TEXTURE_2D);

	glBindTexture(GL_TEXTURE_2D, 0);
	//Texture 2

	glGenTextures(1, &boxTexture);
	glBindTexture(GL_TEXTURE_2D, boxTexture);

	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	
	Mat logo = imread("cBox.jpg",CV_LOAD_IMAGE_COLOR);

	glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, logo.cols, logo.rows, 0, GL_RGB, GL_UNSIGNED_BYTE, logo.data);
	glGenerateMipmap(GL_TEXTURE_2D);


	glBindTexture(GL_TEXTURE_2D, 0);

	
	//Create variables for loop
	float alpha = glfwGetTime()/10;

	double k = (2 * glm::pi<double>()) / (cubePositions.size()/10);
	int r = 50;

	//Loop until close request
	while (!glfwWindowShouldClose(window))
	{
		//Rotate the light source
		alpha = glfwGetTime()/2;
		lightPos = glm::vec3(cos(alpha)*r, 20, sin(alpha)*r);//+camera.Position;

		if (cam) {
			//Capture frame
			cap >> frame;
		

			//Set frame as texture
			glBindTexture(GL_TEXTURE_2D, boxTexture);

			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, frame.cols, frame.rows, 0, GL_RGB, GL_UNSIGNED_BYTE, frame.data);
		

			glBindTexture(GL_TEXTURE_2D, 0);

			flip(frame, frame, 1);
			Mat gray;
			cvtColor(frame, frame, CV_BGR2RGB);
			cvtColor(frame, gray, CV_RGB2GRAY);

			//For controlling with your head
			
			if ((eyeR.width == 0 && eyeR.height == 0) || keys[GLFW_KEY_SPACE]) {
				firstMouse = true;
				eyeR = Rect(0, 0, 0, 0);
				detectEye(gray, eye, eyeR);
			}
			else {
				trackEye(gray, eye, eyeR);
				mouse_callback(window, eyeR.x, eyeR.y);

				//face.copyTo(frame(eyeR));
			}

			
		}
		else {

			glBindTexture(GL_TEXTURE_2D, boxTexture);

			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, logo.cols, logo.rows, 0, GL_RGB, GL_UNSIGNED_BYTE, logo.data);


			glBindTexture(GL_TEXTURE_2D, 0);
		}
		
		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, texture);
		glUniform1i(lightRender["tex"], 0);

		//Calculating FPS
		GLfloat currentFrame = glfwGetTime();
		deltaTime = currentFrame - lastFrame;
		lastFrame = currentFrame;

		// Handel events
		glfwPollEvents();
		Do_Movement();

		//Clear the buffers
		glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);


		//Camera transformations
		glm::mat4 view;
		view = camera.GetViewMatrix();
		glm::mat4 projection;
		projection = glm::perspective(camera.Zoom, (float)screenWidth / (float)screenHeight, 0.1f, 1000.0f);

		//Render the object
		render.use();
		render.bind();



		//Inizalising the shader uniforms
		glUniformMatrix4fv(render["view"], 1, GL_FALSE, glm::value_ptr(view));
		glUniformMatrix4fv(render["projection"], 1, GL_FALSE, glm::value_ptr(projection));
		
		glUniform3f(render["lightPos"], lightPos.x, lightPos.y, lightPos.z);
		glUniform3f(render["lightColor"], 1.0f, 1.0f, 1.0f);
		glUniform3f(render["viewPos"], camera.Position.x, camera.Position.y, camera.Position.z);




		
			// Calculate the model matrix for each object and pass it to shader before drawing
			
			glUniformMatrix4fv(render["model"], 1, GL_FALSE, glm::value_ptr(glm::mat4()));

			render.draw();
		
		render.unbind();


		//Render light source
		lightRender.use();
		lightRender.bind();



		glUniformMatrix4fv(lightRender["view"], 1, GL_FALSE, glm::value_ptr(view));
		glUniformMatrix4fv(lightRender["projection"], 1, GL_FALSE, glm::value_ptr(projection));

		
		glm::mat4 lmodel = glm::translate(glm::mat4(), lightPos);
		glUniformMatrix4fv(lightRender["model"], 1, GL_FALSE, glm::value_ptr(lmodel));
		lightRender.draw();
	
		lightRender.unbind();



		


		boxRender.use();
		boxRender.bind();


		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, boxTexture);
		glUniform1i(boxRender["tex"], 0);

		glUniformMatrix4fv(boxRender["view"], 1, GL_FALSE, glm::value_ptr(view));
		glUniformMatrix4fv(boxRender["projection"], 1, GL_FALSE, glm::value_ptr(projection));

		for (GLuint i = 0; i < cubePositions.size(); i++) {
			glm::mat4 model;
			model = glm::translate(model, cubePositions[i]);
			
			model = glm::rotate(model, (GLfloat)(i * 77), glm::vec3(0.0f, 1.0f, 0.0f));
			
			glUniformMatrix4fv(boxRender["model"], 1, GL_FALSE, glm::value_ptr(model));

			boxRender.draw();
		}

		boxRender.unbind();

		// Swap the buffers
		glfwSwapBuffers(window);
	}

	glfwTerminate();

	return 0;
}


void Do_Movement()
{
	// Camera controls
	if (keys[GLFW_KEY_W])
		camera.ProcessKeyboard(FORWARD, deltaTime);
	if (keys[GLFW_KEY_S])
		camera.ProcessKeyboard(BACKWARD, deltaTime);
	if (keys[GLFW_KEY_A])
		camera.ProcessKeyboard(LEFT, deltaTime);
	if (keys[GLFW_KEY_D])
		camera.ProcessKeyboard(RIGHT, deltaTime);
	if (keys[GLFW_KEY_C]) {
		cam = true;
		firstMouse = true;
	}
	if (keys[GLFW_KEY_M]) {
		cam = false;
		firstMouse = true;
	}
}

// Is called whenever a key is pressed/released via GLFW
void key_callback(GLFWwindow* window, int key, int scancode, int action, int mode)
{

	if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS)
		glfwSetWindowShouldClose(window, GL_TRUE);
	if (key >= 0 && key < 1024)
	{
		if (action == GLFW_PRESS)
			keys[key] = true;

		else if (action == GLFW_RELEASE)
			keys[key] = false;
	}
}

void mouse_callback(GLFWwindow* window, double xpos, double ypos)
{
	if (firstMouse)
	{

		lastX = xpos;
		lastY = ypos;
		firstMouse = false;
		
	}

	GLfloat xoffset = xpos - lastX;
	GLfloat yoffset = ypos - lastY; 

	if (!cam)
		yoffset = lastY - ypos;

	lastX = xpos;
	lastY = ypos;

	camera.ProcessMouseMovement(xoffset, yoffset);
}


void scroll_callback(GLFWwindow* window, double xoffset, double yoffset)
{
	camera.ProcessMouseScroll(yoffset);
}

void detectEye(Mat img, Mat &output, Rect &r) {
	r = Rect(0, 0, 0, 0);
	vector<Rect> faces, eyes;

	
	face_cascade.detectMultiScale(img, faces, 1.1, 2, CV_HAAR_SCALE_IMAGE, Size(30, 30));

	for (int i = 0; i < faces.size(); ++i) {
		r = faces[i];
		output = img(faces[i]);
	}

}

void trackEye(Mat img, Mat &output, Rect &r) {
	Size size(r.width * 2, r.height * 2);

	Rect window(r + size - Point(size.width / 2, size.height / 2));

	window &= Rect(0, 0, img.cols, img.rows);

	Mat dst(window.width - output.rows + 1, window.height - output.cols + 1, CV_8UC1);

	//Compare images
	matchTemplate(img(window), output, dst, CV_TM_SQDIFF_NORMED);

	double minval, maxval;
	Point minloc, maxloc;
	minMaxLoc(dst, &minval, &maxval, &minloc, &maxloc);

	if (minval <= 0.2) {

		r.x = window.x + minloc.x;
		r.y = window.y + minloc.y;

	}
	else
		detectEye(img, output, r);
	

}

