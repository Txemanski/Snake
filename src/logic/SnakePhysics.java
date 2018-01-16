package logic;

import java.awt.Point;
import java.util.LinkedList;

class SnakePhysics {
	
	private final int HEIGHT, WIDTH;
	private LinkedList<Point> levelWalls;
	
	protected SnakePhysics(int height, int width, LinkedList<Point> levels) {
		
		this.HEIGHT = height;
		this.WIDTH = width;
		
		levelWalls = levels;
		
	}
	
	protected void changeDirection(Point p) {
		
	}
	
	protected Point getTarget() {return null;}
	
	protected Point getHead() {return null;}
	
	protected boolean isCollision() {
		return false;
	}

}
