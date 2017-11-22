package logic;

import java.awt.Point;
import java.util.LinkedList;

import logic.levels.*;

public class LevelPainter {
	
	private static final LevelFileCounter counter = new LevelFileCounter();
	private static final int totalLevels = counter.getNumberofLevels(); 
	
	protected LinkedList<Point> getWalls(int height, int width, int level){
		
		LinkedList<Point> result = new LinkedList<Point>();
		LevelParser parser = new LevelParser();
		int relativeLevel = level % totalLevels;
		
		parser.getWalls(relativeLevel).forEach(wall -> {
			
			int xStart = wall.getStart().x * width / 100, xEnd = wall.getEnd().x * width / 100;
			int yStart = wall.getStart().y * height / 100, yEnd = wall.getEnd().y * height / 100;
			
			new Bresenham(xStart, yStart, xEnd, yEnd).getLine().forEach(p -> result.add(p));
		});	
		result.forEach(p -> System.out.println(p.x + " _ " + p.y));
		return result;
	}

	
}
