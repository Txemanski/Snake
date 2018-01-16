package logic;

import java.awt.Point;
import java.util.LinkedList;

class SnakePhysics {
	
	private final int HEIGHT, WIDTH;
	private LinkedList<Point> levelWalls, body = new LinkedList<Point>();
	private Point target, direction, head;
	
	protected SnakePhysics(int height, int width, LinkedList<Point> levels) {
		
		this.HEIGHT = height;
		this.WIDTH = width;
		
		levelWalls = levels;
		
	}
	
	protected void changeDirection(Point p) {
		
		if (Math.abs(p.x + direction.x) == 1 || Math.abs(p.y + direction.y) == 1) {
			direction = p;
		}
		
	}
	
	protected Point getTarget() {return target;}
	
	protected Point getHead() {return head;}
	
	protected boolean isCollision() {return body.contains(head) || levelWalls.contains(head);}

}
