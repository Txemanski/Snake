package gui.state;

import java.awt.Graphics;
import java.util.Set;

import gui.Window;
import logic.SnakeStatus;

public class GameContext {

	protected final SnakeStatus game = new SnakeStatus(Window.BOARD_HEIGHT, Window.BOARD_WIDTH);
	private final BasicStates BSTATES = new BasicStates(this);
	
	
	private GameState currentState;
	
	public GameContext() {
		currentState = BSTATES.get("MENU");
	}
	
	protected void setState(String newState) {currentState = BSTATES.get(newState) ;}
	
	protected void setStatebyOption(int option) {currentState = BSTATES.get(BSTATES.getOptionMap().get(option)) ;}
	
	protected Set <Integer> getOptionSet() {return BSTATES.getOptionSet();}
	
	protected int getOptionSize(){return BSTATES.getOptionSize();}
	
	protected String getOptionName(int order) {return BSTATES.getOptionMap().get(order);}
	
	public void upPressed() { currentState.upPressed(); }

	public void downPressed() {	currentState.downPressed();	}

	public void leftPressed() {	currentState.leftPressed(); }

	public void rightPressed() { currentState.rightPressed(); }

	public void spacePressed() { currentState.spacePressed(); }
	
	public void drawState (Graphics g, int horizontal, int vertical) { currentState.drawGraphics(g, horizontal, vertical); }
	
	public int getSpeed() {
		return game.getSpeed();
	}
}
