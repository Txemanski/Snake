package logic;

import java.awt.Point;
import java.util.LinkedList;

public class Bresenham {

	private int xStart, xEnd, yStart, yEnd;
	LinkedList<Point> line = new LinkedList<Point>();

	public Bresenham(int x0, int y0, int x1, int y1) {
		xStart = x0;
		xEnd = x1;
		yStart = y0;
		yEnd = y1;
	}

	public LinkedList<Point> getLine() {

		int diffX = xEnd - xStart, diffY = yEnd - yStart;
		int incX = diffX < 0 ? -1 : 1;
		int incY = diffY < 0 ? -1 : 1;

		diffX = diffX * incX;
		diffY = diffY * incY;

		line.add(new Point(xStart, yStart));

		if (diffX > diffY) {

			int pK = 2 * diffY - diffX, incE = 2 * diffY, incNE = 2 * (diffY - diffX);

			while (xStart != xEnd) {

				xStart += incX;

				if (pK < 0)
					pK += incE;
				else {
					yStart += incY;
					pK += incNE;
				}

				line.add(new Point(xStart, yStart));
			}

		} else {
			
			int pK = 2 * diffX - diffY, incE = 2 * diffX, incNE = 2 * (diffX - diffY);

			while (yStart != yEnd) {

				yStart += incY;

				if (pK < 0)
					pK += incE;
				else {
					xStart += incX;
					pK += incNE;
				}

				line.add(new Point(xStart, yStart));
			}
		}

		return line;

	}

}
