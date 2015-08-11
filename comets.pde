class comet{
  //float centre'
  int count =0;
  PImage img;
  public float x,y;
  public float wid,hgt;
  public boolean visible =true, shift_ryt=true;
  public comet(float a, float c){
    x=a;
    y=c;
    img=loadImage("monster.png");
    wid=width/10;
    hgt=height/10;
  }
  
  void draw(){
    if(visible){
      image(img,x,y,width/10,height/15);
    }    
  }
  
  boolean collided(float Ox, float Oy){
    if(Ox>x && Ox<(x+img.width) && Oy>y && Oy<(y +img.height))
      return true;
    return false;
  }
}

