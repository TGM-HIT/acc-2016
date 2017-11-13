#version 430 core

out vec4 color;

in vec2 texVert;

uniform sampler2D tex;

void main(){
	color = texture(tex,texVert);
 }