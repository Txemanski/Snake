package gui.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import gui.Window;
import logic.SnakeStatus;

public class Play implements GameState {
	
	private SnakeStatus game = new SnakeStatus(Window.BOARD_HEIGHT, Window.BOARD_WIDTH);
	private GameContext gc;
	
	public Play(GameContext c) {
		gc = c;
		
	}

	@Override
	public void upPressed() {
		game.changeDirection(SnakeStatus.UP);

	}

	@Override
	public void downPressed() {
		game.changeDirection(SnakeStatus.DOWN);
	}

	@Override
	public void leftPressed() {
		game.changeDirection(SnakeStatus.LEFT);

	}

	@Override
	public void rightPressed() {
		game.changeDirection(SnakeStatus.RIGHT);

	}

	@Override
	public void spacePressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawGraphics(Graphics g, int horizontal, int vertical) {
		
		if (game.isGameOver()) gc.setState(gc.BSTATES.get("END"));
		
		g.setColor(Color.GREEN);
		game.updateSnake().forEach(p -> g.fillOval(p.x * Window.SQUARE_SIZE + horizontal, p.y * Window.SQUARE_SIZE + vertical, Window.SQUARE_SIZE - 1, Window.SQUARE_SIZE- 1));
		
		g.setColor(Color.BLUE);
		g.fillRect(game.getTarget().x * Window.SQUARE_SIZE + horizontal, game.getTarget().y * Window.SQUARE_SIZE + vertical, Window.SQUARE_SIZE - 1, Window.SQUARE_SIZE - 1);
		
		g.setColor(Color.RED);
		g.fillOval(game.getHead().x * Window.SQUARE_SIZE + horizontal, game.getHead().y * Window.SQUARE_SIZE + vertical, Window.SQUARE_SIZE - 1, Window.SQUARE_SIZE - 1);
		
	
	g.setColor(Color.YELLOW);
	g.setFont(new Font("Comic Sans", Font.BOLD, Window.FONT_SIZE / 2));
	g.drawString("Score: " + game.getScore(), horizontal,
			vertical - Window.FONT_SIZE);
		
	}

}
