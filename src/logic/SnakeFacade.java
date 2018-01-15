package logic;

import java.awt.Point;
import java.util.LinkedList;

public class SnakeFacade {
	
	public static final Point UP = new Point(0,-1), DOWN = new Point(0, 1), RIGHT = new Point(1, 0), LEFT = new Point(-1, 0);
	private final int HEIGHT, WIDTH;
	
	private SnakeStatus gameStatus;
	private SnakeElements snakeBody;
	private boolean canChangeDirection = true;
	
	public SnakeFacade(int height, int width) {
		
		this.HEIGHT = height;
		this.WIDTH = width;
		gameStatus = new SnakeStatus(HEIGHT, WIDTH);
		snakeBody = new SnakeElements(HEIGHT, WIDTH);
		
	}
	
	public LinkedList<Point> updateSnake(){
		
		//Here all the code, the last line must be the following
		canChangeDirection = true;
		return null;
	}
	
	public void changeDirection(Point p) {
		
		if (canChangeDirection) {
			snakeBody.changeDirection(p);
			canChangeDirection = false;
		}
		
	}
	
	public void reset() {
		
		gameStatus = new SnakeStatus(HEIGHT, WIDTH);
		snakeBody = new SnakeElements(HEIGHT, WIDTH);		
	}
	
	public void levelUp() {
		
		snakeBody = new SnakeElements(HEIGHT, WIDTH);
		gameStatus.levelUp();
	}
	
	public LinkedList<Point> getLevel() {return null;}
	
	public boolean isChangeLevel() {return false;}
	
	public boolean isGameOver() {return snakeBody.checkGameOver();}
	
	public int getSpeed() {return gameStatus.getSpeed();}

	public int getScore() {return gameStatus.getScore();}

	public Point getTarget() {return snakeBody.getTarget();}
	
	public Point getHead() {return snakeBody.getHead();}
}
