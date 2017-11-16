package logic;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class SnakeStatus {
	
	public static final Point UP = new Point(0,-1), DOWN = new Point(0, 1), RIGHT = new Point(1, 0), LEFT = new Point(-1, 0);
	private final int HEIGHT, WIDTH;
	private LinkedList<Point> Snake = new LinkedList<Point>();
	private Point target, direction, head;
	
	public SnakeStatus(int height, int width) {
		
		this.HEIGHT = height;
		this.WIDTH = width;
		generateTarget();
		generateDirectionandHead();
		
	}
	
	private void generateTarget() {target = new Point(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT));}
	
	private void generateDirectionandHead() {
		int x = new Random().nextInt(WIDTH - WIDTH / 5) + WIDTH / 10;
		int y = new Random().nextInt(HEIGHT - HEIGHT / 5) + HEIGHT / 10;
		
		if (y < HEIGHT / 4) direction = DOWN;
		else if (y > HEIGHT * 3 / 4) direction = UP;
		else if (x > WIDTH / 2) direction = LEFT;
		else direction = RIGHT;
				
		head = new Point(x, y);
	}
	
	public Point getTarget() {return target;}
	
	public LinkedList<Point> updateSnake(){
		
		Snake.addFirst(new Point(head.x, head.y));
		if (head.equals(target)) {
			generateTarget();
		}
		else {
			Snake.removeLast();
		}
		
		head.x = (head.x + direction.x) % (WIDTH) > -1 ? (head.x + direction.x) % (WIDTH) : (WIDTH - 1);
		head.y = (head.y + direction.y) % (HEIGHT - 1) > -1 ? (head.y + direction.y) % (HEIGHT - 1) : (HEIGHT - 1);
		

		return Snake;
	}
	
	public Point getHead() {return head;}
	
	public void changeDirection(Point p) {
		
		if (Math.abs(p.x + direction.x) == 1 || Math.abs(p.y + direction.y) == 1) 
			direction = p;
	}

}
