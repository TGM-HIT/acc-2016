#version 430 core

layout (location = 4) in vec3 position;
layout (location = 5) in vec2 texV;


uniform mat4 projection;
uniform mat4 view;
uniform mat4 model;

out vec2 texVert;

void main(){
	gl_Position = projection * view * model * vec4(position,1.0f);
	texVert = texV;
}
