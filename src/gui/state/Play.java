package gui.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import gui.Window;
import logic.SnakeStatus;

public class Play implements GameState {
	
	private final GameContext gc;
	
	public Play(GameContext c) {
		gc = c;
		
	}

	@Override
	public void upPressed() {
		gc.game.changeDirection(SnakeStatus.UP);

	}

	@Override
	public void downPressed() {
		gc.game.changeDirection(SnakeStatus.DOWN);
	}

	@Override
	public void leftPressed() {
		gc.game.changeDirection(SnakeStatus.LEFT);

	}

	@Override
	public void rightPressed() {
		gc.game.changeDirection(SnakeStatus.RIGHT);

	}

	@Override
	public void spacePressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawGraphics(Graphics g, int horizontal, int vertical) {
		
		if (gc.game.isGameOver()) gc.setState(gc.BSTATES.get("END"));
		
		g.setColor(new Color(0xDA8A5F));
		gc.game.getLevel().forEach(p -> g.fillRect(p.x * Window.SQUARE_SIZE + horizontal, p.y * Window.SQUARE_SIZE + vertical, Window.SQUARE_SIZE, Window.SQUARE_SIZE));
		
		g.setColor(Color.GREEN);
		gc.game.updateSnake().forEach(p -> g.fillOval(p.x * Window.SQUARE_SIZE + horizontal, p.y * Window.SQUARE_SIZE + vertical, Window.SQUARE_SIZE - 1, Window.SQUARE_SIZE- 1));
		
		g.setColor(Color.BLUE);
		g.fillRect(gc.game.getTarget().x * Window.SQUARE_SIZE + horizontal, gc.game.getTarget().y * Window.SQUARE_SIZE + vertical, Window.SQUARE_SIZE - 1, Window.SQUARE_SIZE - 1);
		
		g.setColor(Color.RED);
		g.fillOval(gc.game.getHead().x * Window.SQUARE_SIZE + horizontal, gc.game.getHead().y * Window.SQUARE_SIZE + vertical, Window.SQUARE_SIZE - 1, Window.SQUARE_SIZE - 1);
		
	
	g.setColor(Color.YELLOW);
	g.setFont(new Font("Comic Sans", Font.BOLD, Window.FONT_SIZE / 2));
	g.drawString("Score: " + gc.game.getScore(), horizontal,
			vertical - Window.FONT_SIZE);
		
	}

}
