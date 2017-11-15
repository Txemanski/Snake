package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private static final long serialVersionUID = 8698427445604449743L;	
	private JPanel canvas = new JPanel();

	public Window(String string) {
		
		super(string);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add(masterUI.cPanel, BorderLayout.CENTER);
		//add(masterUI.bPanel, BorderLayout.SOUTH);
		setSize(1000, 1000);	
		add(canvas);

	}
	
	private class Canvas extends JPanel {
		
	}

}
