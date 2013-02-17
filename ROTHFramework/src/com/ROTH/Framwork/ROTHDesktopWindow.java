package com.ROTH.Framwork;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

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
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		this.setSize( (int)(toolkit.getScreenSize().width * 0.9), (int)(toolkit.getScreenSize().height * 0.9) );
		//this.setResizable(false);
		this.setVisible(true);
		
		if(controller != null)
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

	@Override
	public void SetJMenuBar(JMenuBar menuBar) {
		this.setJMenuBar(menuBar);
		
	}
	
}
