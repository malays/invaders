class ship{
  PImage ship;
  int speed;
  float x,y;
  public ship(int s){
    speed =s;
    ship=loadImage("ship.jpeg");
    x=width/2;
    y=height-50.0;
  }
  
  void draw(){    
    image(ship,int(x),int(y));    
  }
  
  boolean isWithin(float xOut, float yOut){
    if(xOut>x && xOut<(x+ship.width) && yOut>y && yOut<(y+ship.height)){
      return true;
    }
    else{
      return false;
    }
  }
  
  void up(){
    y-=speed;
    image(ship,int(x),int(y));
  }
  
  void down(){
    y+=speed;
    image(ship,int(x),int(y));
  }
  
  void left(){
    x-=speed;
    image(ship,int(x),int(y));
  }
  
  void right(){
    x+=speed;
    image(ship,int(x),int(y));
  }
  
  float getX(){
    return x;
  }
  
  float getY(){
    return y;
  }
  
  float wid(){
    return ship.width;
  }
  
  float hgt(){
    return ship.height;
  }
}

