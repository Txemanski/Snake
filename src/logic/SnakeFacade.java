package logic;

import java.awt.Point;
import java.util.LinkedList;

public class SnakeFacade {
	
	public static final Point UP = new Point(0,-1), DOWN = new Point(0, 1), RIGHT = new Point(1, 0), LEFT = new Point(-1, 0);
	private final int HEIGHT, WIDTH;
	private final LevelPainter levels;
	
	private SnakeStatus gameStatus;
	private SnakePhysics physics;
	private boolean canChangeDirection = true;
	
	public SnakeFacade(int height, int width) {
		
		this.HEIGHT = height;
		this.WIDTH = width;
		levels = new LevelPainter(HEIGHT, WIDTH);
		gameStatus = new SnakeStatus(HEIGHT, WIDTH);
		physics = new SnakePhysics(HEIGHT, WIDTH, levels.getWalls(gameStatus.getLevel()));
		
	}
	
	public LinkedList<Point> updateSnake(){
		
		//Here all the code, the last line must be the following
		canChangeDirection = true;
		return null;
	}
	
	public void changeDirection(Point p) {
		
		if (canChangeDirection) {
			physics.changeDirection(p);
			canChangeDirection = false;
		}
		
	}
	
	public void reset() {
		
		gameStatus = new SnakeStatus(HEIGHT, WIDTH);
		physics = new SnakePhysics(HEIGHT, WIDTH, levels.getWalls(gameStatus.getLevel()));		
	}
	
	public void levelUp() {
		
		gameStatus.levelUp();
		physics = new SnakePhysics(HEIGHT, WIDTH, levels.getWalls(gameStatus.getLevel()));
	}
	
	public LinkedList<Point> getLevel() {return levels.getWalls(gameStatus.getLevel());}
	
	public boolean isChangeLevel() {return gameStatus.isChangeLevel();}
	
	public boolean isGameOver() {return physics.isCollision();}
	
	public int getSpeed() {return gameStatus.getSpeed();}

	public int getScore() {return gameStatus.getScore();}

	public Point getTarget() {return physics.getTarget();}
	
	public Point getHead() {return physics.getHead();}
}
