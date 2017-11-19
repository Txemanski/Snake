package gui.state;

import java.util.HashMap;

public class MenuOptions extends HashMap<String, GameState> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6749968807169267528L;
	
	protected MenuOptions(GameContext g) {
		this.put("OPTIONS", new Options(g));
		this.put("PLAY", new Play(g));
	}

}
