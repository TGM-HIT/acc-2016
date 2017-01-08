int COLOR_RANGE = 255;

void settings() {
  size(displayWidth/3, displayHeight/3*2);
}

int size, h, tw, th, wm;
color stemColor, treeColor, starColor;

Ball balls[];

void setup() {
  frameRate(60);
  colorMode(HSB, COLOR_RANGE, 100, 100);
  textAlign(CENTER, CENTER);
  smooth();
  balls = new Ball[10];
  
  noStroke();
  stemColor = color(20, 87, 60);
  treeColor = color(101, 78, 61);
  println(map(54, 0, 360, 0, 255));
  starColor = color(38, 100, 54);
  
  size = width-50;
  h = height;    // Height
  tw = size/10;  // Tree Width
  th = (int)(tw*1.25);  // Tree Heights
  wm = width/2;  // Width Middle
  
  int ballSize = size/23;
  for(int i = 0; i < balls.length; i++) {
    balls[i] = new Ball(i*ballSize+(ballSize/2), ballSize/2, ballSize, (COLOR_RANGE/balls.length)*i);
  }
  textSize(ballSize*2);
  
}

void draw() {
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
  rotate(-0.261799);
  star(0, 0, 10, 30, 5);
  popMatrix();
  
  for(int i = 0; i < balls.length; i++) {
    balls[i].paint();
  }
  for(int i = 0; i < balls.length; i++) {
    balls[i].nextColor();
  }
}

void star(float x, float y, float radius1, float radius2, int npoints) {
  float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0;
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

void keyPressed() {
  if(keyCode == ' ') {
    for(int i = 0; i < balls.length; i++) {
      balls[i].setColor(0);
    }
  }
}