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
			
			int xStart = wall.getStart().x * height / 100, xEnd = wall.getEnd().x * height / 100;
			int yStart = wall.getStart().y * width / 100, yEnd = wall.getEnd().y * width / 100;
			int xMultiplier = (xStart - xEnd) < 0 ? -1 : 1;
			int yMultiplier = (yStart - yEnd) < 0 ? -1 : 1;
			
			if (xStart == yStart || xEnd == yEnd) {
				
				while (xStart != xEnd) {
					while(yStart != yEnd) {
						result.add(new Point(xStart, yStart));
						yStart += yMultiplier; 						
					}
					xStart += xMultiplier;
				}
			}			
			
		});	
		
		result.forEach(p -> System.out.println(p));
		
		return result;
	}

	
}
