class bullet{
  float x,y;
  int len=3;
  
  public bullet(float a, float b){
    x=a;
    y=b;
    //bulletCount--;
  }
  
  void draw(){
    strokeWeight(5);
    stroke(255,0,0);
    //point(x,y);
    line(x,y,x+1,y+len);
    y-=10;
  }
  
  float getY(){
    return y;
  }
  
  float getX(){
    return x;
  }
}



