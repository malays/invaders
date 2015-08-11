package malay.labs;

import processing.core.*;

public class ship {
	PApplet parent;
	PImage ship;
	static int speed;
	float x,y;
	int wid,hgt;
	
	public ship(PApplet p){		
		parent=p;		
		ship=parent.loadImage("ship.png");
		x=parent.width/2;
		y=parent.height-50.0f;
		wid=parent.width/40;
		hgt=parent.height/40;
	}

	public void draw(){    
		parent.image(ship,PApplet.parseInt(x),PApplet.parseInt(y));    
	}

	public boolean isWithin(float xOut, float yOut){
		if(xOut>x && xOut<(x+ship.width) && yOut>y && yOut<(y+ship.height)){
			return true;
		}
		else{
			return false;
		}
	}

	public void up(){
		y-=speed;
		parent.image(ship,PApplet.parseInt(x),PApplet.parseInt(y));
	}

	public void down(){
		y+=speed;
		parent.image(ship,PApplet.parseInt(x),PApplet.parseInt(y));
	}

	public void left(){
		x-=speed;
		parent.image(ship,PApplet.parseInt(x),PApplet.parseInt(y));
	}

	public void right(){
		x+=speed;
		parent.image(ship,PApplet.parseInt(x),PApplet.parseInt(y));
	}

	public float getX(){
		return x;
	}

	public float getY(){
		return y;
	}

	public float wid(){
		return wid;
	}

	public float hgt(){
		return hgt;
	}
}
