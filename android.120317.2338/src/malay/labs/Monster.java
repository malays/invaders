package malay.labs;

import java.util.LinkedList;
import java.util.List;

import processing.core.*;

class Monster{
	//float centre'
	int width,height;
	PImage img;
	PApplet parent;
	public float x,y;
	public static float wid;
	public static float hgt;
	public boolean visible =true;
	int n;
	static int count;
	public Monster(float a, float c, PApplet p){
		x=a;
		y=c;
		parent=p;
		width=parent.width;
		height=parent.height;
		img=parent.loadImage("monster.png");
		n=0;
	}

	public void draw(){
		switch(n){
		case 0:
		case 1:
		case 2:
		case 3:
		//case 4:
		//case 5:
			x+=5;
			n++;
			break;
		case 4:
		case 5:
		case 6:
		case 7:
//		case 8:
//		case 9:
//		case 10:		
			x-=5;
			n++;
			break;
		case 8:
			n=0;	
			break;
		}
		if(visible){
			parent.image(img,x,y);
		}    
	}

	public void drawwithdown(){
		switch(n){
		case 0:
		case 1:
			x+=wid/3;
			n++;
			break;
		case 2:
		case 3:
			x-=wid/3;
			n++;
			break;
		case 4:
			n=0;	
			y+=hgt/2;
			break;
		}
		if(visible){
			parent.image(img,x,y,width/10,height/15);
		}    
	}

	
	public boolean collided(float Ox, float Oy){
		if(Ox>x && Ox<(x+img.width) && Oy>y && Oy<(y +img.height))
			return true;
		return false;
	}
}

class MonsterField{
	List<Monster> monsters;
	PApplet parent;
	int comWid = 30;
	//x = x coordinate on screen
	//y = y coordinate on screen
	public MonsterField(int n, int x,int y, PApplet p)
	{		
		parent =p;
		monsters = new LinkedList<Monster>();
		for (int i=0;i<n;i++)
		{
			monsters.add(new Monster(comWid*i,15,p));
		}
	}	
	
	void draw()
	{
		
	}
	
}