package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 8698427445604449743L;	

	public Window(String string) {
		
		super(string);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add(masterUI.cPanel, BorderLayout.CENTER);
		//add(masterUI.bPanel, BorderLayout.SOUTH);
		setSize(1000, 1000);	

	}

}
