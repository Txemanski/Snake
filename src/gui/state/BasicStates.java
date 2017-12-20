package gui.state;

import java.util.HashMap;
import java.util.Set;

public final class BasicStates extends HashMap<String, GameState> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6749968807169267528L;
	
	private HashMap<String, GameState> mapofOptions;
	
	protected BasicStates(GameContext g) {
		
		mapofOptions = new MenuOptions(g);	
		
		this.put("MENU", new Menu(g));
		this.put("END", new End(g));
		this.put("LEVELUP", new LevelUp(g));
					
	}
	
	protected GameState getOption (String s) {
		
		return mapofOptions.get(s);
		
	}
	
	protected Set<String> getSetofOptions (){	
		return mapofOptions.keySet();
	}

}
