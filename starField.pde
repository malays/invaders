class star{
  float x,y,z;
  public star(float a ,float b,float c){
    x=a;
    y=b;
    z=c;
  }
}

public class starField{
  int count;
  star stars[];
  public starField(int c){
    count=c;
    stars=new star[count];
    for(int i=0;i<count;i++){
      stars[i]=new star(random(width),random(height),random(10));
    }
  }
  
  void draw(){
    strokeWeight(2);

    for(int i=0;i<count;i++){     
      stroke(stars[i].z*25);
      point(stars[i].x,stars[i].y);
      stars[i].y+=stars[i].z;
      if(stars[i].y>height)
      {
        stars[i]=new star(random(width),0,sqrt(random(100)));
      }
    }
   
  }
}

