package malay.labs;

import processing.core.*;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.LinkedList;
import java.util.List;

public class Invaders2 extends PApplet {
	bullet b;
	ship shp;
	starField stars;
	boolean fired = false;
	LinkedList<Monster> comets;
	int comWid, comHgt; 
	int comCount=10;
	int coms=10;
	static int score = 0;
	PFont pf;

	public void setup(){
		SharedPreferences spf = getSharedPreferences("speed",MODE_PRIVATE);
	    ship.speed = spf.getInt("shipSpeed", 10);
		bullet.speed = spf.getInt("bulletSpeed", 20);
		comWid = 30;
		Monster.wid = comWid;
		Monster.hgt = comHgt;
		frameRate(20);
		stars=new starField(100,this);
		smooth();
		shp=new ship(this);
		Monster.count = coms;	
		comets = new LinkedList<Monster>();
		for(int i=0;i<comCount;i++)
		{
			comets.add(new Monster(comWid*i,15,this));
		}
		pf = loadFont("ARDARLING-48.vlw");
	}

	public void draw(){
		if(comCount<=0){
			textFont(pf,36);
			background(0);
			text("You saved your planet!\n Score: " + score,10,100);
			Intent intent = new Intent(this,level2.class);
			startActivity(intent);
			finish();
		}
		else{			
			background(0);
			stars.draw();
			pushMatrix();  
			shp.draw();
			if(fired==true){
				b.draw();
			} 
			for(int i=0;i<comCount;i++)
			{   
				Monster c= comets.get(i); 
				c.draw();   
				//if(fired && b.y-c.y<c.hgt && b.x>(c.x+c.wid/4) && b.x<(c.x+3*c.wid/4) && comets[i].visible)
				if(fired && b.y-c.y<comHgt && b.x>(c.x) && b.x<(c.x+comWid))
				{
					comets.remove(i);					
					fired=false;
					score++;
					comCount--;
				}
			}    
			popMatrix();
			if(mousePressed==true)
			{
				if(shp.isWithin(mouseX,mouseY)){
					b=new bullet(shp.getX()+shp.wid()/2,shp.getY(),true,this);       
					b.draw();  
					fired=true;
				}
				else{					
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
}
