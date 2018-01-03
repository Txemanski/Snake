package gui.state;

import java.awt.Graphics;

import gui.Window;
import logic.SnakeStatus;

public class GameContext {

	protected final SnakeStatus game = new SnakeStatus(Window.BOARD_HEIGHT, Window.BOARD_WIDTH);
	protected final BasicStates BSTATES = new BasicStates(this);
	
	
	private GameState currentState;
	
	public GameContext() {
		
		getOptions();
		currentState = BSTATES.get("MENU");
	}
	
	protected void setState(GameState newState) {currentState = newState;}
	
	public void upPressed() { currentState.upPressed(); }

	public void downPressed() {	currentState.downPressed();	}

	public void leftPressed() {	currentState.leftPressed(); }

	public void rightPressed() { currentState.rightPressed(); }

	public void spacePressed() { currentState.spacePressed(); }
	
	public void drawState (Graphics g, int horizontal, int vertical) { currentState.drawGraphics(g, horizontal, vertical); }
	
	public int getSpeed() {
		return game.getSpeed();
	}
	
	private void getOptions() {
		
	}
}
