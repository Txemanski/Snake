package gui.state;

import java.util.HashMap;
import java.util.Set;

public final class BasicStates extends HashMap<String, GameState> {

	private static final long serialVersionUID = 6749968807169267528L;

	private static final boolean menuOption = true, notMenuOption = false;
	
	private final HashMap<Integer, String> MOPTIONS = new HashMap<Integer, String>();
	private Set <Integer> optionSet;
	private int order = 0, optionSize;
	
	protected BasicStates(GameContext g) {
				
		this.put("MENU", new Menu(g, notMenuOption));
		this.put("END", new End(g, notMenuOption));
		this.put("LEVELUP", new LevelUp(g, notMenuOption));
		this.put("OPTIONS", new Options(g, menuOption));
		this.put("PLAY", new Play(g, menuOption));
		
		setOptions();
					
	}
	
	private void setOptions() {
		
		this.forEach((s, gs) -> {
			if (gs.isMenuOption()) {
				MOPTIONS.put(order, s);
				order++;
			}
		});
		
		optionSet = MOPTIONS.keySet();
		optionSize = MOPTIONS.size();
		
	}
	
	protected HashMap<Integer, String> getOptionMap(){
		return MOPTIONS;
	}
	
	protected Set <Integer> getOptionSet(){
		return optionSet;
	}
	
	protected int getOptionSize() {
		return optionSize;
	}

}
