package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import logic.SnakeStatus;

public class Window extends JFrame implements KeyListener{

	private static final long serialVersionUID = 8698427445604449743L;
	private Canvas canvas = new Canvas();
	private SnakeStatus game = new SnakeStatus();
	private Timer timerGame = new Timer(100, e -> canvas.repaint());

	public Window(String string) {
		
		super(string);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		canvas.setBounds(0, 0, 1000, 1000);
		this.setBackground(Color.BLUE);
		add(canvas);
		canvas.addKeyListener(this);
		canvas.setFocusable(true);
		canvas.repaint();
		timerGame.start();
	}
	
	private class Canvas extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.setBackground(Color.BLACK);
			
			g.setColor(Color.GREEN);
			game.updateSnake().forEach(p -> g.fillOval(p.x * 20, p.y * 20, 19, 19));
			
			g.setColor(Color.BLUE);
			g.fillRect(game.getTarget().x * 20, game.getTarget().y * 20, 19, 19);
			
			g.setColor(Color.RED);
			g.fillOval(game.getHead().x * 20, game.getHead().y * 20, 19, 19);
						
		}
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		switch (arg0.getKeyCode()){
		case KeyEvent.VK_UP:
			game.changeDirection(SnakeStatus.UP);
			break;
		case KeyEvent.VK_DOWN:
			game.changeDirection(SnakeStatus.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			game.changeDirection(SnakeStatus.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			game.changeDirection(SnakeStatus.RIGHT);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
