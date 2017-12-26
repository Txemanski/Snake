package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class SnakeStatus {
	
	public static final Point UP = new Point(0,-1), DOWN = new Point(0, 1), RIGHT = new Point(1, 0), LEFT = new Point(-1, 0);
	private static final int MAX_GROWTH = 16;
	private final int HEIGHT, WIDTH;
	
	private ArrayList<LinkedList<Point>> levelList = new ArrayList<LinkedList<Point>>();
	private LinkedList<Point> snake = new LinkedList<Point>();
	private Point target, direction, head;
	private boolean gameOver = false, canChangeDirection = true, changeLevel = false;
	private int score = 0, growCounter = 0, level = 0, targetsEaten = 0, speed = 0;
	
	public SnakeStatus(int height, int width) {
		
		this.HEIGHT = height;
		this.WIDTH = width;
		this.getWalls();
		generateTarget();
		generateDirectionandHead();
		
	}
	
	private void generateTarget() {
		do {
			target = new Point(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT));
		} while (snake.contains(target) || levelList.get(level).contains(target));
	}
	
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
		
		gameOver = snake.contains(head) || levelList.get(level).contains(head);
		
		LinkedList<Point> tempList = new LinkedList<Point>();
		
		snake.forEach(p -> tempList.add(p));
		
		snake.addFirst(new Point(head.x, head.y));
		
		if (head.equals(target)) {
			generateTarget();
			growCounter = Math.min(snake.size(), MAX_GROWTH);
			score+= growCounter;
			targetsEaten++;
		}
		else if (growCounter > 1){
			growCounter--;
		}
		else {
			if (!gameOver)snake.removeLast();
			
		}
		if (!gameOver) {
			head.x = (head.x + direction.x) % (WIDTH) > -1 ? (head.x + direction.x) % (WIDTH) : (WIDTH - 1);
			head.y = (head.y + direction.y) % (HEIGHT - 1) > -1 ? (head.y + direction.y) % (HEIGHT) : (HEIGHT - 1);
		}
		
		changeLevel = targetsEaten > 9;
		
		canChangeDirection = true;
		return snake;
	}
	
	public Point getHead() {return head;}
	
	public void changeDirection(Point p) {
		
		boolean condition = (Math.abs(p.x + direction.x) == 1 || Math.abs(p.y + direction.y) == 1) && canChangeDirection;
		
		if (condition) {
			direction = p;
			canChangeDirection = false;
		}
	}
	
	public boolean isGameOver() {return gameOver;}
	public boolean isChangeLevel() {return changeLevel;}
	
	public String getScore() {return Integer.toString(score);	}
	
	public void reset() {
		generateTarget();
		generateDirectionandHead();
		gameOver = false;
		snake.clear();
		score = 0;
		level = 0;
		speed = 0;
		targetsEaten = 0;
		growCounter = 0;
	}
	
	public void getWalls() {
		
		LevelPainter walls = new LevelPainter();
		levelList = walls.getWalls(HEIGHT - 1, WIDTH - 1);
		
	}
	
	public LinkedList<Point> getLevel() {
		return levelList.get(level);
	}
	
	public void levelUp() {
		targetsEaten = 0;
		recalculateLevel();
		snake.clear();
		changeLevel = false;
		growCounter = 0;
	}
	
	private void recalculateLevel() {
		
		int maxLevel = levelList.size();
		level = speed * maxLevel + level;
		level++;
		speed = level / maxLevel;
		level = level % maxLevel;
	}
	
	public int getSpeed() {
		return speed;
	}

}
