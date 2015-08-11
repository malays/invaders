package malay.labs;

import processing.core.*;

public class bullet {
	PApplet parent;
	float x,y;
	int len=3;
	static int speed=0;
	boolean isShip;
	public bullet(float a, float b, boolean shp,PApplet p){
		parent=p;
		x=a;
		y=b;
		isShip=shp;
		//bulletCount--;
	}

	public void draw(){
		parent.strokeWeight(5);
		parent.stroke(255,0,0);
		//point(x,y);
		
		if(isShip){
			parent.line(x,y,x+1,y+len);
			y-=speed;
		}
		else{
			parent.line(x,y+len,x+1,y+2*len);
			y+=speed/10;
		}
	}

	public float getY(){
		return y;
	}

	public float getX(){
		return x;
	}
}
