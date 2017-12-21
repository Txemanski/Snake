package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import gui.state.GameContext;

public class Window extends JFrame implements KeyListener{

	private static final long serialVersionUID = 8698427445604449743L;
	public static final int BOARD_HEIGHT = 30, BOARD_WIDTH = 50;
	public static final int SQUARE_SIZE = 25, FONT_SIZE = 40, INITIAL_SPEED = 50;
	
	private GameContext game = new GameContext();
	private Canvas canvas = new Canvas();
	private Timer timerGame = new Timer(INITIAL_SPEED, e -> canvas.repaint());

	public Window(String string) {
		
		super(string);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setBackground(Color.BLUE);
		add(canvas);
		canvas.addKeyListener(this);
		canvas.setFocusable(true);
		canvas.repaint();
		timerGame.start();
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		switch (arg0.getKeyCode()){
		case KeyEvent.VK_UP:
			game.upPressed();
			break;
		case KeyEvent.VK_DOWN:
			game.downPressed();
			break;
		case KeyEvent.VK_LEFT:
			game.leftPressed();
			break;
		case KeyEvent.VK_RIGHT:
			game.rightPressed();
			break;
		case KeyEvent.VK_SPACE:
			game.spacePressed();
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	private class Canvas extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.setBackground(Color.DARK_GRAY);
			
			int relativeX = this.getWidth() / 2 - BOARD_WIDTH * SQUARE_SIZE / 2, 
					relativeY = this.getHeight() / 2 - BOARD_HEIGHT * SQUARE_SIZE / 2;
			
			g.setColor(Color.BLACK);
			g.fillRect(relativeX, relativeY, BOARD_WIDTH * SQUARE_SIZE, BOARD_HEIGHT * SQUARE_SIZE);
			
			game.drawState(g, relativeX, relativeY);
			
		}
		
		
		
	}


}
