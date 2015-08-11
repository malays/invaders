package malay.labs;

import processing.core.*;
import android.content.Intent;
import android.content.SharedPreferences;


public class level2 extends PApplet {

	bullet b[];
	bullet bShip;
	boolean fired[];
	starField stars;
	ship Ship;
	int score;
	Monster comets[];
	int comWid,comCount=10,coms=10;
	PFont pf;
	boolean fShip=false;
		
	public void setup(){		  
		comWid=width/10;
		frameRate(20);
		stars=new starField(100,this);
		smooth();
		Ship=new ship(this);
		comets=new Monster[coms];
		for(int i=0;i<coms;i++)
		{
			int h1=0;
			int h2 = 100; 
			if(i<coms/2)
			{
				comets[i]=new Monster((15 +comWid*2*i)%width,h1,this);
			}
			else
			{
				int x = (15 +comWid*2*i)%width;
				comets[i]=new Monster(x,h2,this);
			}
			
		}		
		pf = loadFont("ARDARLING-48.vlw");
		b=new bullet[comCount];
		fired = new boolean[comCount];
	}
	
	public void draw(){
		if(comCount==0){
			textFont(pf,36);
			background(0);
			text("You saved your planet!\n Score: " + score,10,100);
			Intent intent = new Intent(this,level3.class);
			startActivity(intent);
			finish();
		}
		else if(comCount==-1){
			textFont(pf,36);
			background(0);
			text("You got hit!\n Score: " + score,10,100);
		}
		else{
			background(0);
			stars.draw();
			pushMatrix();  
			Ship.draw();
			if(fShip==true){
				bShip.draw();
			} 
			Monster c;
			for(int i=0;i<coms;i++)
			{   
				c= comets[i]; 
				c.draw();				
				//if(fShip && bShip.y-c.y<c.hgt && bShip.x>(c.x+c.wid/4) && bShip.x<(c.x+3*c.wid/4) && comets[i].visible)
				if(fShip && bShip.y-c.y<c.hgt && bShip.x>(c.x) && bShip.x<(c.x+c.wid) && comets[i].visible)
				{
					comets[i].visible = false;
					fShip=false;
					score++;
					comCount--;
				}				
			}    
			popMatrix();
			if(mousePressed==true)
			{
				if(Ship.isWithin(mouseX,mouseY)){
					bShip=new bullet(Ship.getX()+Ship.wid()/2,Ship.getY(), true,this);       
					bShip.draw();  
					fShip=true; 
		//			bulletCount--; 
				}
				else{
					if(mouseY<Ship.y  && mouseX>Ship.x && mouseX-Ship.x<Ship.wid()){
						Ship.up();
					}
					if(mouseY>Ship.y && mouseX>Ship.x && mouseX-Ship.x<Ship.wid()){
						Ship.down();
					}
					if(mouseX<Ship.x && mouseY>Ship.y && mouseY-Ship.y<Ship.hgt()){
						Ship.left();
					}
					if(mouseX>Ship.x && mouseY>Ship.y && mouseY-Ship.y<Ship.hgt()){
						Ship.right();
					}
				}
			}
			//logic for comets's firing
			int firingComet = (int)random(coms*25);
			if(firingComet<coms && comets[firingComet].visible){
				b[firingComet]=new bullet(comets[firingComet].x + comets[firingComet].wid/2, comets[firingComet].y, false, this);
				fired[firingComet] = true;
			}
			for(int i=0; i<coms;i++)
			{
				if(fired[i])
				{
					b[i].draw();
				
				//collision with ship
				if(b[i].x>Ship.x && b[i].x<(Ship.x+Ship.wid()) && b[i].y>=Ship.y && (b[i].y<=Ship.y+Ship.hgt()))
				{
					comCount=-1;
				}
				}
			}			
		}
	}
	
}
