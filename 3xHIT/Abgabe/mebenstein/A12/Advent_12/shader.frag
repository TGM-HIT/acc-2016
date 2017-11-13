#version 430 core

out vec4 color;

uniform vec3 lightPos;
uniform vec3 lightColor;
uniform vec3 viewPos;

in vec3 normalVec;
in vec3 fragPos;

float specStren = 0.2f;
float ambientStren = 0.1f;

void main()
{
	

	if(normalVec != 0){
	vec3 norm = normalize(normalVec);
	vec3 lightDir = normalize(lightPos-fragPos);

	float diff = max(dot(norm,lightDir),0.0);
	vec3 diffuse = diff * lightColor;

	vec3 ambient = ambientStren * lightColor;

	vec3 viewDir = normalize(viewPos-fragPos);
	vec3 reflectDir = reflect(-lightDir,norm);

	float spec = pow(max(dot(viewDir,reflectDir),0.0),32);

	vec3 specular = specStren * spec * lightColor;
	
	vec3 res = (ambient + diffuse + specular)* vec3(0.0,0.392,0.0); 
	

    color = vec4(res,1.0);
	}
}