package gui.state;

import java.awt.Graphics;

abstract class GameState {
	
	protected final GameContext gc;
	private final boolean menuOption;
	
	public GameState(GameContext c, boolean mo) {
		gc = c;
		menuOption = mo;
		
	}
	
	public boolean isMenuOption() {return menuOption;}

	abstract void upPressed();

	abstract void downPressed();

	abstract void leftPressed();

	abstract void rightPressed();

	abstract void spacePressed();

	abstract void drawGraphics(Graphics g, int horizontal, int vertical);

}
