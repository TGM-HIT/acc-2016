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
    this.farbe = 0.0;
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