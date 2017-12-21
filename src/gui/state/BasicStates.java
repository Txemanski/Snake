package gui.state;

import java.util.HashMap;

public final class BasicStates extends HashMap<String, GameState> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6749968807169267528L;
	
	
	
	protected BasicStates(GameContext g) {
				
		this.put("MENU", new Menu(g));
		this.put("END", new End(g));
		this.put("LEVELUP", new LevelUp(g));
					
	}

}
