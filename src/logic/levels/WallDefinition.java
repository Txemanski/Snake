package logic.levels;

import java.awt.Point;

public class WallDefinition {
	
	Point start = new Point(), end = new Point();
	
	protected Point getStart() { return start;}
	protected Point getEnd() { return end;}
	@Override
	public String toString() {
		
		return ("{(" + start.x + " - " + start.y + ") (" + end.x + " - " + end.y + ")}");
	}

}
