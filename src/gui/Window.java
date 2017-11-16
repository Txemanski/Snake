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
	
	private static final int BOARDHEIGHT = 50, BOARDWIDTH =80, SQUARESIZE = 15;
	private Canvas canvas = new Canvas();
	private SnakeStatus game = new SnakeStatus(BOARDHEIGHT, BOARDWIDTH);
	private Timer timerGame = new Timer(100, e -> canvas.repaint());

	public Window(String string) {
		
		super(string);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(BOARDWIDTH * SQUARESIZE, BOARDHEIGHT * SQUARESIZE);
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
			this.setBackground(Color.DARK_GRAY);
			
			int relativeX = this.getWidth() / 2 - BOARDWIDTH * SQUARESIZE / 2, relativeY = this.getHeight() / 2 - BOARDHEIGHT * SQUARESIZE / 2;
			
			g.setColor(Color.BLACK);
			g.fillRect(relativeX, relativeY, BOARDWIDTH * SQUARESIZE, BOARDHEIGHT * SQUARESIZE);
			
			g.setColor(Color.GREEN);
			game.updateSnake().forEach(p -> g.fillOval(p.x * SQUARESIZE + relativeX, p.y * SQUARESIZE + relativeY, SQUARESIZE - 1, SQUARESIZE- 1));
			
			g.setColor(Color.BLUE);
			g.fillRect(game.getTarget().x * SQUARESIZE + relativeX, game.getTarget().y * SQUARESIZE + relativeY, SQUARESIZE - 1, SQUARESIZE - 1);
			
			g.setColor(Color.RED);
			g.fillOval(game.getHead().x * SQUARESIZE + relativeX, game.getHead().y * SQUARESIZE + relativeY, SQUARESIZE - 1, SQUARESIZE - 1);
						
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
