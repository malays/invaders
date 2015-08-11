bullet b;
ship shp;
starField stars;
boolean fired = false;
comet comets[];
int comWid, comCount;
static int bulletCount;
static int score = 0;
PFont pf;
void setup(){
//  size(300,400);
  comWid = width/10;  
  frameRate(20);
  stars=new starField(100);
  smooth();
  shp=new ship(10);
  comets=new comet[10];
  for(int i=0;i<10;i++)
  {
    comets[i]=new comet(15 +comWid*i,15);
  }
  pf = loadFont("ARDARLING-48.vlw");
  bulletCount=12;
}

void draw(){
  if(bulletCount<=0){
    textFont(pf,36);
    background(0);
    text("out of bullets!\n Score: " + score,10,100);
 //   return;
  }
  else{
  background(0);
  stars.draw();
  pushMatrix();  
  shp.draw();
  if(fired==true){
     b.draw();
  } 
  for(int i=0;i<10;i++)
  {   
   comet c= comets[i]; 
   c.draw();   
   if(fired && b.y-c.y<c.hgt && b.x>c.x && b.x-c.x<c.wid && comets[i].visible)
   {
     comets[i].visible = false;
     fired=false;
     score++;
   }
  }    
  popMatrix();
  if(mousePressed==true)
  {
    if(shp.isWithin(mouseX,mouseY)){
      b=new bullet(shp.getX()+shp.wid()/2,shp.getY());       
      b.draw();  
      fired=true; 
      bulletCount--; 
    }
    else{
    if(mouseY<shp.y  && mouseX>shp.x && mouseX-shp.x<shp.wid()){
      shp.up();
    }
    if(mouseY>shp.y && mouseX>shp.x && mouseX-shp.x<shp.wid()){
      shp.down();
    }
    if(mouseX<shp.x && mouseY>shp.y && mouseY-shp.y<shp.hgt()){
      shp.left();
    }
    if(mouseX>shp.x && mouseY>shp.y && mouseY-shp.y<shp.hgt()){
      shp.right();
    }
    }
  }  
}
}

