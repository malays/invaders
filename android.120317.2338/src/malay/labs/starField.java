package malay.labs;

import processing.core.*;

public class starField {
	int count;
	float width,height;
	star stars[];
	PApplet parent;
	public starField(int c, PApplet p){
		parent=p;
		count=c;
		width=parent.width;
		height=parent.height;
		stars=new star[count];
		for(int i=0;i<count;i++){
			stars[i]=new star(parent.random(width),parent.random(height),parent.random(10));
		}		
	}

	public void draw(){
		parent.strokeWeight(2);

		for(int i=0;i<count;i++){     
			parent.stroke(stars[i].z*25);
			parent.point(stars[i].x,stars[i].y);
			stars[i].y+=stars[i].z;
			if(stars[i].y>parent.height)
			{
				stars[i]=new star(parent.random(width),0,PApplet.sqrt(parent.random(100)));
			}
		}

	}
}

class star{
	float x,y,z;
	public star(float a ,float b,float c){
		x=a;
		y=b;
		z=c;
	}
}

