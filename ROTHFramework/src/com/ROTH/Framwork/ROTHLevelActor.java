package com.ROTH.Framwork;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ROTHLevelActor {
	
	private int PosX;
	private int PosY;
	private final String tag;
	
	private int spriteWidth = 32;
	private int spriteHeight = 48;
	private int currentSpritePosX = 0;
	private int currentSpritePosY = 0;
	private int animationCounter = 0;
	private long animationTimer = System.currentTimeMillis();
	private int animationTiming = 200;
	private String animation = "normal";
	
	Image actor = null;
	
	public ROTHLevelActor(String tag, Image actor, int x, int y) {
		this.tag = tag; 
		//this.actor = actor;
		try {
			this.actor = ImageIO.read(new File("assets/hero.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PosX=x;
		PosY=y;
	}
	
	public void SetPosition(int x, int y){
		this.setPosX(x);
		this.setPosY(y);
	}
	
	public void move(int x, int y){
		setPosX(getPosX() + x);
		setPosY(getPosY() + y);
	}

	

	public String getTag() {
		return tag;
	}

	public int getPosX() {
		return PosX;
	}

	public void setPosX(int posX) {
		PosX = posX;
	}

	public int getPosY() {
		return PosY;
	}

	public void setPosY(int posY) {
		PosY = posY;
	}
	
	public void draw(Graphics2D g2d){
		
		g2d.drawImage(this.actor, this.getPosX(), this.getPosY(), this.getPosX()+50, this.getPosY()+60, currentSpritePosX, currentSpritePosY, currentSpritePosX+spriteWidth, currentSpritePosY+spriteHeight, null);
	
		//System.out.println(animation+" "+currentSpritePosX+" "+currentSpritePosY);
		
	}
	
	public void animate(String action){
		
		if(action.equals(animation)){
			if(System.currentTimeMillis() - animationTimer > animationTiming){
				animationCounter++;
				currentSpritePosX=spriteWidth*animationCounter;
				animationTimer = System.currentTimeMillis();
			}
			if(animationCounter>2)
				animationCounter=0;
		}
		else if(action.equals("left")){
			animation = "left";
			currentSpritePosY = spriteHeight*2;
			currentSpritePosX = 0;
			animationCounter=0;
		}
		else if(action.equals("right")){
			animation = "right";
			currentSpritePosY = spriteHeight*1;
			currentSpritePosX = 0;
			animationCounter=0;
		}
		else if(action.equals("down")){
			animation = "down";
			currentSpritePosY = spriteHeight*0;
			currentSpritePosX = 0;
			animationCounter=0;
		}
		else if(action.equals("up")){
			animation = "up";
			currentSpritePosY = spriteHeight*3;
			currentSpritePosX = 0;
			animationCounter=0;
		}
		
		
		
	}

	public int getSpriteWidth() {
		return spriteWidth;
	}

	public void setSpriteWidth(int spriteWidth) {
		this.spriteWidth = spriteWidth;
	}

	public int getSpriteHeight() {
		return spriteHeight;
	}

	public void setSpriteHeight(int spriteHeight) {
		this.spriteHeight = spriteHeight;
	}
	

}
