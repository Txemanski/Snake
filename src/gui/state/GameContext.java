package gui.state;

import java.awt.Graphics;

public class GameContext {

	protected final BasicStates BSTATES = new BasicStates(this);
	protected final MenuOptions MOPTIONS = new MenuOptions(this);
	
	private GameState currentState = MOPTIONS.get("PLAY");
	
	protected void setState(GameState newState) { currentState = newState; }
	
	public void upPressed() { currentState.upPressed(); }

	public void downPressed() {	currentState.downPressed();	}

	public void leftPressed() {	currentState.leftPressed(); }

	public void rightPressed() { currentState.rightPressed(); }

	public void spacePressed() { currentState.spacePressed(); }
	
	public void drawState (Graphics g, int horizontal, int vertical) { currentState.drawGraphics(g, horizontal, vertical); }
}
