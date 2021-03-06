package com.ROTH.Framwork;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;


public class ROTHDesktopLevelPanel extends JPanel implements ROTHPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7716687111718904098L;
	private ArrayList<ArrayList<Image>> map = new ArrayList<ArrayList<Image>>();
	
	private ROTHLevelActor user = new ROTHLevelActor("User",null,this.getWidth()/2,this.getHeight()/2);
	private ArrayList<ROTHLevelActor> actors = new ArrayList<ROTHLevelActor>();
	private ROTHController controller=null;
	private int Xoffset=0;
	private int Yoffset=0;
	private int speedModifier = ROTHConstants.INITSPEEDMOD;
	
	public ROTHDesktopLevelPanel(ArrayList<ArrayList<Image>> map, ROTHController controller){
		
		super();
		this.setBackground(Color.BLACK);
		this.map = map;
		this.controller = controller;
		
	}
	


	public void paint(Graphics g0) {
			
		super.paint(g0);
		
		Logic();
		
		int Xscale = ROTHConstants.TILESIZE;
		int Yscale = ROTHConstants.TILESIZE;
		Graphics2D g2d = (Graphics2D) g0;
	
		
		for(int x = 0; x<1000; x++){
			for(int y = 0; y < 1000; y++){
		
				if( Math.abs((x*Xscale+Xoffset - user.getPosX())) > 60*Xscale || Math.abs(y*Yscale+Yoffset - user.getPosY()) > 60*Yscale){
					
				}else{
					g2d.drawImage(map.get(x).get(y), Xoffset+x*Xscale, Yoffset+y*Yscale, Xscale, Yscale, null);
				}
			
			
			}
		}

		user.draw(g2d);
		
	}
	
	public void Logic(){
		
		int x = controller.getDirX();
		int y = controller.getDirY();
		
		if(controller.getDirX() >= 1 && user.getPosX() > this.getSize().width*5/6){
			Xoffset-=speedModifier;
			x=0;
			user.animate("left");
		}else if(controller.getDirX() <= -1 && user.getPosX() < this.getSize().width*1/6){
			Xoffset+=speedModifier;
			x=0;
			user.animate("right");
		}else if(controller.getDirY() == 1 && user.getPosY() > this.getSize().height*5/6){
			Yoffset-=speedModifier;
			y=0;
			user.animate("down");
		}else if(controller.getDirY() == -1 && user.getPosY() < this.getSize().height*1/6){
			Yoffset+=speedModifier;
			y=0;
			user.animate("up");
		} else if(x>0){
			user.animate("left");
			user.move(x*speedModifier, y*speedModifier);
		}else if(x<0){
			user.animate("right");
			user.move(x*speedModifier, y*speedModifier);
		}else if(y>0){
			user.animate("down");
			user.move(x*speedModifier, y*speedModifier);
		}else if(y<0){
			user.animate("up");
			user.move(x*speedModifier, y*speedModifier);
		}
		
		//user.move(x,y);
		
		//System.out.println(user.getPosX()+"  "+user.getPosY());
		
	}



	public ArrayList<ROTHLevelActor> getActors() {
		return actors;
	}



	public void setActors(ArrayList<ROTHLevelActor> actors) {
		this.actors = actors;
	}



	@Override
	public void setMap(ArrayList<ArrayList<Image>> map) {
		this.map = map;
		
	}

	
	


}
