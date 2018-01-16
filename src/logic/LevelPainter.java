package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

import logic.levels.*;

class LevelPainter {
	
	private static final LevelFileCounter counter = new LevelFileCounter();
	private static final int totalLevels = counter.getNumberofLevels(); 
	private ArrayList<LinkedList<Point>> levelList = new ArrayList<LinkedList<Point>>();
	
	protected LevelPainter () {
		//TODO - Constructor to be deleted
		super();
	}
	
	protected LevelPainter (int height, int width) {
		
		LevelParser parser = new LevelParser();
		
		for (int i = 0; i < totalLevels; i++) {
			LinkedList<Point> level = new LinkedList<Point>();
			parser.getWalls(i).forEach(wall -> {
				
				int xStart = wall.getStart().x * width / 100, xEnd = wall.getEnd().x * width / 100;
				int yStart = wall.getStart().y * height / 100, yEnd = wall.getEnd().y * height / 100;
				
				new Bresenham(xStart, yStart, xEnd, yEnd).getLine().forEach(p -> level.add(p));
			});	
			levelList.add(i, level);
		}
		
	}
	
	protected ArrayList<LinkedList<Point>> getWalls(int height, int width){
		
		//TODO - Method to be deleted
		
		LevelParser parser = new LevelParser();
		
		for (int i = 0; i < totalLevels; i++) {
			LinkedList<Point> level = new LinkedList<Point>();
			parser.getWalls(i).forEach(wall -> {
				
				int xStart = wall.getStart().x * width / 100, xEnd = wall.getEnd().x * width / 100;
				int yStart = wall.getStart().y * height / 100, yEnd = wall.getEnd().y * height / 100;
				
				new Bresenham(xStart, yStart, xEnd, yEnd).getLine().forEach(p -> level.add(p));
			});	
			levelList.add(i, level);
		}
		
		return levelList;
	}
	
	protected LinkedList<Point> getWalls(int level){
		return levelList.get(level);
	}

	
}
