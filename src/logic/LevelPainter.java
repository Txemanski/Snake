package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

import logic.levels.*;

public class LevelPainter {
	
	private static final LevelFileCounter counter = new LevelFileCounter();
	private static final int totalLevels = counter.getNumberofLevels(); 
	
	protected ArrayList<LinkedList<Point>> getWalls(int height, int width){
		
		ArrayList<LinkedList<Point>> result = new ArrayList<LinkedList<Point>>();
		
		LevelParser parser = new LevelParser();
		
		for (int i = 0; i < totalLevels; i++) {
			LinkedList<Point> level = new LinkedList<Point>();
			parser.getWalls(i).forEach(wall -> {
				
				int xStart = wall.getStart().x * width / 100, xEnd = wall.getEnd().x * width / 100;
				int yStart = wall.getStart().y * height / 100, yEnd = wall.getEnd().y * height / 100;
				
				new Bresenham(xStart, yStart, xEnd, yEnd).getLine().forEach(p -> level.add(p));
			});	
			result.add(i, level);
		}
		
		return result;
	}

	
}
