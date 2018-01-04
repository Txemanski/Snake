package logic;

import java.awt.Point;
import java.util.LinkedList;

public class SnakeStatusNew {
	
	private final int HEIGHT, WIDTH;
	
	public SnakeStatusNew(int height, int width) {
		
		this.HEIGHT = height;
		this.WIDTH = width;
		
	}
	
	public Point getTarget() {return null;}
	
	public LinkedList<Point> updateSnake(){return null;}

	public Point getHead() {return null;}
	
	public void changeDirection(Point p) {}
	
	public boolean isGameOver() {return true;}
	
	public boolean isChangeLevel() {return true;}
	
	public int getScore() {return 0;}
	
	public void getWalls() {}
	
	public LinkedList<Point> getLevel() {return null;}
	
	public void levelUp() {}
	
	public int getSpeed() {return 0;}
}
