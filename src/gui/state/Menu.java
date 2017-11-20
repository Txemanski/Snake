package gui.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Set;

import gui.Window;

public class Menu implements GameState {
	
	private final GameContext gc;
	
	private int optionSelected = 0;
	private HashMap<Integer, String> listofOptions = new HashMap<Integer,String>();
	private HashMap<String, GameState> mapofOptions;
	private final Set<String> setofOptions;
	
	public Menu (GameContext c) {

		gc = c;
		mapofOptions = new MenuOptions(gc);
		
		setofOptions = mapofOptions.keySet();
		
		setofOptions.forEach(s -> {listofOptions.put(optionSelected, s);
			optionSelected++;
		});
		
		optionSelected = 0;		
	}

	@Override
	public void upPressed() {

		optionSelected = (optionSelected < 1) ? listofOptions.size() - 1: optionSelected - 1;

	}

	@Override
	public void downPressed() {
		optionSelected = ++optionSelected % listofOptions.size();

	}

	@Override
	public void leftPressed() {
		this.spacePressed();

	}

	@Override
	public void rightPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void spacePressed() {
		gc.setState(mapofOptions.get(listofOptions.get(optionSelected)));

	}

	@Override
	public void drawGraphics(Graphics g, int horizontal, int vertical) {

		g.setColor(Color.YELLOW);
		g.setFont(new Font("Comic Sans", Font.BOLD,  Window.FONT_SIZE));
		Set <Integer> setofSelectedOptions = listofOptions.keySet();
		setofSelectedOptions.forEach(i -> {
			if (i == optionSelected) g.setColor(Color.YELLOW);
			else g.setColor(Color.LIGHT_GRAY);
			g.drawString(listofOptions.get(i), horizontal + Window.BOARD_WIDTH * Window.SQUARE_SIZE/ 2 - Window.FONT_SIZE * 5,
					vertical + (i + 1) * Window.FONT_SIZE + Window.BOARD_HEIGHT * Window.SQUARE_SIZE / 2);
			
		});		
	}

}