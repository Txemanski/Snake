package logic;

import java.awt.Point;

class SnakeBody {

	private final int HEIGHT, WIDTH;
	
	protected SnakeBody(int height, int width) {
		
		this.HEIGHT = height;
		this.WIDTH = width;
		
	}
	
	protected Point getTarget() {return null;}
	
	protected Point getHead() {return null;}
	
	protected boolean checkGameOver() {return false;}
	
	protected void changeDirection(Point p) {
		
	}
		
		
}
