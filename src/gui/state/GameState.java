package gui.state;

import java.awt.Graphics;

interface GameState {

	void upPressed();

	void downPressed();

	void leftPressed();

	void rightPressed();

	void spacePressed();

	void drawGraphics(Graphics g, int horizontal, int vertical);

}
