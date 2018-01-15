package gui.state;

import java.awt.Graphics;

public class Exit extends GameState {

	public Exit(GameContext c, boolean mo) {
		super(c, mo);
	}

	@Override
	void upPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	void downPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	void leftPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	void rightPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	void spacePressed() {
		// TODO Auto-generated method stub

	}

	@Override
	void drawGraphics(Graphics g, int horizontal, int vertical) {
		System.exit(0);

	}

}
