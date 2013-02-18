package com.ROTH.Framwork;

import javax.swing.JMenuBar;

public interface ROTHWindow{
	
	public void SetName(String name);
	public void SetVisible(boolean value);
	public void addChild(Object obj);
	public void SetJMenuBar(JMenuBar menuBar);
	public void Repaint();

}
