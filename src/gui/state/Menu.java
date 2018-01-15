package gui.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import gui.Window;

public class Menu extends GameState {
	
	private int optionSelected = 0;
	
	public Menu(GameContext c, boolean mo) {
		super(c, mo);
		
	}

	@Override
	public void upPressed() {

		optionSelected = (optionSelected < 1) ? gc.getOptionSize() - 1: optionSelected - 1;

	}

	@Override
	public void downPressed() {
		optionSelected = ++optionSelected % gc.getOptionSize();

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
		gc.setStatebyOption(optionSelected);

	}

	@Override
	public void drawGraphics(Graphics g, int horizontal, int vertical) {

		g.setColor(Color.YELLOW);
		g.setFont(new Font("Serif", Font.BOLD,  Window.FONT_SIZE));
		
		gc.getOptionSet().forEach(i -> {
			if (i == optionSelected) g.setColor(Color.YELLOW);
			else g.setColor(Color.LIGHT_GRAY);
			g.drawString(gc.getOptionName(i), horizontal + Window.BOARD_WIDTH * Window.SQUARE_SIZE/ 2 - Window.FONT_SIZE * 5,
					vertical + (i + 1) * Window.FONT_SIZE + Window.BOARD_HEIGHT * Window.SQUARE_SIZE / 2);
			
		});		
	}

}