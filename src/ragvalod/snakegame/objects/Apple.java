package ragvalod.snakegame.objects;

import ragvalod.snakegame.SnakeGame;

public class Apple {
	
	public int positionX;
	public int positionY;
	
	public Apple(int startX, int startY) {
		positionX = startX;
		positionY = startY;
	}
	public void setRandomPosition() {
		positionX = (int) ((Math.random() * 100) % (SnakeGame.WIDTH));
		positionY = (int) ((Math.random() * 100) % (SnakeGame.HEIGHT));
	}
	
}
