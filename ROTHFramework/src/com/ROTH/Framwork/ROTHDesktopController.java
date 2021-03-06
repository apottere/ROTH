package com.ROTH.Framwork;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;




public class ROTHDesktopController implements ROTHController, KeyListener {

	
	private ArrayList<Character> actions = new ArrayList<Character>();
	
	private boolean[] dir = new boolean[4];
	public ArrayList<Character> getActionList() {
		return actions;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==(KeyEvent.VK_W) || e.getKeyCode()==(KeyEvent.VK_UP)){
			dir[0]=true;
		}else if(e.getKeyCode()==(KeyEvent.VK_S) || e.getKeyCode()==(KeyEvent.VK_DOWN)){
			dir[1]=true;
		}else if(e.getKeyCode()==(KeyEvent.VK_A) || e.getKeyCode()==(KeyEvent.VK_LEFT)){
			dir[2]=true;
		}else if(e.getKeyCode()==(KeyEvent.VK_D) || e.getKeyCode()==(KeyEvent.VK_RIGHT)){
			dir[3]=true;
		}else{
			//System.out.println("Key is: " + e.getKeyChar());
		}
		
				
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()==(KeyEvent.VK_W) || e.getKeyCode()==(KeyEvent.VK_UP)){
			dir[0]=false;
		}else if(e.getKeyCode()==(KeyEvent.VK_S) || e.getKeyCode()==(KeyEvent.VK_DOWN)){
			dir[1]=false;
		}else if(e.getKeyCode()==(KeyEvent.VK_A) || e.getKeyCode()==(KeyEvent.VK_LEFT)){
			dir[2]=false;
		}else if(e.getKeyCode()==(KeyEvent.VK_D) || e.getKeyCode()==(KeyEvent.VK_RIGHT)){
			dir[3]=false;
		}else{
			//System.out.println("Key is: " + e.getKeyChar());
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDirX() {
		if(dir[2]&&dir[3])
			return 0;
		else if(dir[2])
			return -1;
		else if(dir[3])
			return 1;
		else
			return 0;
	}

	@Override
	public int getDirY() {
		
		if(dir[0]&&dir[1])
			return 0;
		else if(dir[0])
			return -1;
		else if(dir[1])
			return 1;
		else
			return 0;
	}

}
