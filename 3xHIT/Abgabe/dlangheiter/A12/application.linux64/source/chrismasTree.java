import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class chrismasTree extends PApplet {

int COLOR_RANGE = 255;

public void settings() {
  size(displayWidth/3, displayHeight/3*2);
}

int size, h, tw, th, wm;
int stemColor, treeColor, starColor;

Ball balls[];

public void setup() {
  frameRate(60);
  colorMode(HSB, COLOR_RANGE, 100, 100);
  textAlign(CENTER, CENTER);
  
  balls = new Ball[10];
  
  noStroke();
  stemColor = color(20, 87, 60);
  treeColor = color(101, 78, 61);
  println(map(54, 0, 360, 0, 255));
  starColor = color(38, 100, 54);
  
  size = width-50;
  h = height;    // Height
  tw = size/10;  // Tree Width
  th = (int)(tw*1.25f);  // Tree Heights
  wm = width/2;  // Width Middle
  
  int ballSize = size/23;
  for(int i = 0; i < balls.length; i++) {
    balls[i] = new Ball(i*ballSize+(ballSize/2), ballSize/2, ballSize, (COLOR_RANGE/balls.length)*i);
  }
  textSize(ballSize*2);
  
}

public void draw() {
  background(0, 0, 100);
  
  text("Merry Chrismas", width/2, 50);
  
  fill(stemColor);
  rect(width/2-(tw/2), height, tw, -size/5);
  
  fill(treeColor);
  for(int i = 0; i < 5; i++) {
    triangle(wm - tw*(5-i), h-size/5-th*i, wm + tw*(5-i), h-size/5-th*i, wm, h-(th*4+th*i));
    balls[i*2].setPos(wm - tw*(5-i), h-size/5-th*i);
    balls[i*2+1].setPos(wm + tw*(5-i), h-size/5-th*i);
  }
  
  fill(starColor);
  pushMatrix();
  translate(wm, h-(th*4+th*4));
  rotate(-0.261799f);
  star(0, 0, 10, 30, 5);
  popMatrix();
  
  for(int i = 0; i < balls.length; i++) {
    balls[i].paint();
  }
  for(int i = 0; i < balls.length; i++) {
    balls[i].nextColor();
  }
}

public void star(float x, float y, float radius1, float radius2, int npoints) {
  float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0f;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius2;
    float sy = y + sin(a) * radius2;
    vertex(sx, sy);
    sx = x + cos(a+halfAngle) * radius1;
    sy = y + sin(a+halfAngle) * radius1;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}

public void keyPressed() {
  if(keyCode == ' ') {
    for(int i = 0; i < balls.length; i++) {
      balls[i].setColor(0);
    }
  }
}
class Ball {
  private int xPos, yPos, size, offset;
  private double farbe, steps;
  
  public Ball(int xPos, int yPos, int size) {
    this(xPos, yPos, size, 0);
  }
  
  public Ball(int xPos, int yPos, int size, int offset) {
    this(xPos, yPos, size, offset, 1);
  }
  
  public Ball(int xPos, int yPos, int size, int offset, double steps) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.size = size;
    this.offset = offset;
    this.steps = steps;
    this.farbe = 0.0f;
  }
  
  public void paint() {
    ellipseMode(CENTER);
    noStroke();
    fill(color(getColor(), 100, 100));
    ellipse(xPos, yPos, size, size);
  }
  
  public void setPos(int x, int y) {
    this.xPos = x;
    this.yPos = y;
  }
  
  public void setColor(int col) {
    if(col >= 0 && col <= COLOR_RANGE) {
      this.farbe = col;
    }
  }
  
  public int getColor() {
    int ret = ((int)farbe)-offset;
    if(ret < 0) {
      ret = COLOR_RANGE+ret;
    }
    return ret;
  }
  
  public void nextColor() {
    this.farbe = (farbe > COLOR_RANGE-steps ? 0 : farbe+steps);
  }
  
  
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "chrismasTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
