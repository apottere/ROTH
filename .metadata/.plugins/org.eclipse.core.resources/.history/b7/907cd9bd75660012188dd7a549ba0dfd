package com.ROTH.Game;

import java.awt.Image;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import com.ROTH.Framwork.ROTHDesktopLevelPanel;
import com.ROTH.Framwork.ROTHController;
import com.ROTH.Framwork.ROTHDesktopController;
import com.ROTH.Framwork.ROTHDesktopWindow;
import com.ROTH.Framwork.ROTHPanel;
import com.ROTH.Framwork.ROTHWindow;


public class Main {

	
	static Image map = null;
	static ROTHController controller = new ROTHDesktopController();
	static ROTHWindow window = null;
	
	public static void main(String[] args) {
		
		window = new ROTHDesktopWindow(controller);
		
		ROTHPanel panel = null;
		try {
			Image map = ImageIO.read(new File("Assests/tile.png"));
			
			ArrayList<ArrayList<Image>> tileMap = new ArrayList<ArrayList<Image>>();
			
			for(int x = 0; x<100; x++){
				
				ArrayList<Image> temp = new ArrayList<Image>();
				
				for(int y = 0; y < 100; y++){
					temp.add(map);
					
					
				}
				tileMap.add(temp);
			}
			
			panel = new ROTHDesktopLevelPanel(tileMap, controller);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		window.addChild((Object)panel);
		
		
		
		window.SetName("Test");
		window.SetVisible(true);
		
		long timeKeeper = System.currentTimeMillis();
	
		
		while (true) {

		
			
			if (System.currentTimeMillis() - timeKeeper > 10) {

					
					timeKeeper = System.currentTimeMillis();
					panel.repaint();
				}

			}
		}
		

	}


