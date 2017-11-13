By Michael Ebenstein 3AHIT
This program shows a christmas tree and presents in OpenGL. 
There is a lightsource whos texture is the TGM logo. It circulates around the scene to show the lighting better
The presents got a texture like a wrapping paper.
The christmas tree is just green.


Controlls:
Key c: switches to head controll => The camera takes pictures with the webcam (if not provided dont use this program, otherwise it will crash unforuntaly) and detects your head. It then controlls the OpenGL camera via the position of your head (Controlls are inversed). The presents will no longer show the texture of the paper, instead they will show the camera image.
Key m: switches back to mouse mode => mouse controlls the camera
Key w: forward
key a: left
key s: back
key d: right
key space: redetect your head (neccessary if head controll targets something wrong, its not perfect).
key esc: end program
 
This folder proviedes all files neccessary and use in the compilation. If some files are missing the program might not start!