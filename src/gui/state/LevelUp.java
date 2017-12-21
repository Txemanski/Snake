package gui.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import gui.Window;

public class LevelUp implements GameState {
	
	private final GameContext gc;
	
	public LevelUp(GameContext c) {
		gc = c;
		
	}

	@Override
	public void upPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leftPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void spacePressed() {
		gc.game.levelUp();
		gc.setState(gc.MOPTIONS.get("PLAY") );

	}

	@Override
	public void drawGraphics(Graphics g, int horizontal, int vertical) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Comic Sans", Font.BOLD,  Window.FONT_SIZE));
		g.drawString("NEXT LEVEL, READY?", horizontal + Window.BOARD_WIDTH * Window.SQUARE_SIZE/ 2 - Window.FONT_SIZE * 5,
				vertical + Window.BOARD_HEIGHT * Window.SQUARE_SIZE / 2);

	}

}
