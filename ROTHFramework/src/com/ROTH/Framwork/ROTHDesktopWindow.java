package com.ROTH.Framwork;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

public class ROTHDesktopWindow extends JFrame implements ROTHWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1653578647406467260L;

	public ROTHDesktopWindow(ROTHController controller) {
		super();
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		
		this.setVisible(true);
		//this.setSize(1280, 720);
		this.setResizable(false);
		this.addKeyListener((ROTHDesktopController)controller);
		
	}

	@Override
	public void SetName(String name) {
		this.setTitle(name);
		
	}

	@Override
	public void SetVisible(boolean value) {
		this.setVisible(value);
		
	}

	@Override
	public void addChild(Object obj) {
		this.add((Component) obj);
	
	}
	
}
