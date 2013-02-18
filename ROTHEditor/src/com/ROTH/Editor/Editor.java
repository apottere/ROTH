package com.ROTH.Editor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ROTH.Framwork.ROTHDesktopWindow;
import com.ROTH.Framwork.ROTHMap;
import com.ROTH.Framwork.ROTHWindow;

public class Editor implements ActionListener{

	
	private ROTHWindow window = new ROTHDesktopWindow(null);
	private String mapDir;
	private String mapName;
	private JFileChooser chooser = new JFileChooser();
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("ROTH Maps", "rml");
	private String windowName = "ROTH Map Editor";
	
	private Vector<ROTHMap> maps = new Vector<ROTHMap>();
	
	private JMenuBar menuBar = new JMenuBar();
	private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
	
	public Editor() {
		//TODO: TEMPORARY!  (For testing convenience)
		chooser.setCurrentDirectory(new File("Z:\\My Documents\\GitHub\\ROTH\\ROTHGame\\assets\\maps\\"));
		
		chooser.setFileFilter(filter);
		
		buildGUI();
		
	}
	
	private void buildGUI() {
		
		JMenu menu = new JMenu("File");
		
		JMenuItem open = new JMenuItem("Open Map...");
		open.addActionListener(this);
		
		menu.add(open);
		menuBar.add(menu);
		window.SetJMenuBar(menuBar);
		window.SetName(windowName);
		
		window.addChild(tabs);
		
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
			
			window.SetName(windowName + ": " + mapName);
			
			ROTHMap newmap = null;
			try {
				newmap = new ROTHMap(new FileInputStream(getMapPath()));
				maps.add(newmap);
				
				JPanel panel = new JPanel();
				panel.add(new JLabel(newmap.name));
				tabs.add(newmap.name, panel);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
				
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
