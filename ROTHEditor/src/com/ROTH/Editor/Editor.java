package com.ROTH.Editor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.ROTH.Framwork.ROTHDesktopWindow;
import com.ROTH.Framwork.ROTHMapParser;
import com.ROTH.Framwork.ROTHWindow;

public class Editor implements ActionListener{

	
	private ROTHWindow window = new ROTHDesktopWindow(null);
	private String mapDir;
	private String mapName;
	private JFileChooser chooser = new JFileChooser();
	
	private ROTHMapParser parser = new ROTHMapParser();
	
	private JMenuBar menuBar = new JMenuBar();
	
	public Editor() {
		//TODO: TEMPORARY!  (For testing convenience)
		chooser.setCurrentDirectory(new File("Z:\\My Documents\\GitHub\\ROTH\\ROTHGame\\Assests\\maps\\"));
		
		buildGUI();
		
	}
	
	private void buildGUI() {
		
		JMenu menu = new JMenu("File");
		
		JMenuItem open = new JMenuItem("Open Map...");
		open.addActionListener(this);
		
		menu.add(open);
		menuBar.add(menu);
		window.SetJMenuBar(menuBar);
		
		window.SetVisible(true);
		
		
	}

	public String getMapPath() {
		return getMapDirectory() + System.getProperty("file.separator") + getMapName();
	}
	
	public String getMapDirectory() {
		return mapDir;
		
	}
	
	public String getMapName() {
		return mapName;
		
	}
	
	public void chooseMap() {
		int retval = chooser.showOpenDialog((Component) window);
		if(retval == JFileChooser.APPROVE_OPTION) {
			chooser.setCurrentDirectory(chooser.getCurrentDirectory());
			mapDir = chooser.getCurrentDirectory().getAbsolutePath();
			mapName = chooser.getSelectedFile().getName();
			
//			System.out.println("You chose a folder!");
//			System.out.println(this.getMapPath());
			
			this.parseMap();
			
		} else {
//			System.out.println("No file chosen.");
		}
		
	}
	
	
	public void parseMap() {
		
		try {
			parser.parse(getMapPath());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();
		
		if(action.equals("Open Map...")) {
			
			chooseMap();
			
		} else {
		
			System.out.println("Action not recognized: " + action);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Editor editor = new Editor();
		
		editor.chooseMap();
		

	}

	

}
