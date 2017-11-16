package logic;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class SnakeStatus {
	
	public static final Point UP = new Point(0,-1), DOWN = new Point(0, 1), RIGHT = new Point(1, 0), LEFT = new Point(-1, 0);
	private LinkedList<Point> Snake = new LinkedList<Point>();
	private Point target, direction, head;
	
	public SnakeStatus() {
	
		
		generateTarget();
		generateDirectionandHead();
		
	}
	
	private void generateTarget() {
		
		target = new Point(new Random().nextInt(48), new Random().nextInt(48));
		
	}
	
	private void generateDirectionandHead() {
		int x = new Random().nextInt(40) + 5;
		int y = new Random().nextInt(40) + 5;
		
		if (y < 10) direction = DOWN;
		else if (y > 40) direction = UP;
		else if (x < 25) direction = LEFT;
		else direction = RIGHT;
				
		head = new Point(x, y);
	}
	
	public Point getTarget() {
		return target;
	}
	
	public LinkedList<Point> updateSnake(){
		
		Snake.addFirst(new Point(head.x, head.y));
		if (head.equals(target)) {
			generateTarget();
		}
		else {
			Snake.removeLast();
		}
		
		head.x = (head.x + direction.x % 49) > -1 ? (head.x + direction.x % 49) : 49;
		head.y = (head.y + direction.y % 49) > -1 ? (head.y + direction.y % 49) : 48;
		

		return Snake;
	}
	
	public Point getHead() {
		return head;
	}
	
	public void changeDirection(Point p) {
		
		if (Math.abs(p.x + direction.x) == 1 || Math.abs(p.y + direction.y) == 1) 
			direction = p;
	}

}
