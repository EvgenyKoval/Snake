package ragvalod.snakegame.objects;

import ragvalod.snakegame.SnakeGame;
public class Snake {
	
	public int direction = 0;
	public int length = 2;

	public int[] snakeX = new int[300];
	public int[] snakeY = new int[300];

	public Snake(int x0, int y0, int x1, int y1) {
		snakeX[0] = x0;
		snakeX[1] = x1;
		snakeY[0] = y0;
		snakeY[1] = y1;
	}
	public void move() {
	for (int d = length; d > 0; d--) {
		snakeX[d] = snakeX[d - 1];
		snakeY[d] = snakeY[d - 1];
	}
	if (snakeX[0] <= 0 & direction == 2) snakeX[0] = SnakeGame.WIDTH;
	if (snakeX[0] >= SnakeGame.WIDTH - 1 & direction == 0) snakeX[0] = -1;
	if (snakeY[0] <= 0 & direction == 3) snakeY[0] = SnakeGame.HEIGHT;
	if (snakeY[0] >= SnakeGame.HEIGHT - 1 & direction == 1) snakeY[0] = -1;
	if (direction == 0) snakeX[0]++;
	if (direction == 1) snakeY[0]++;
	if (direction == 2) snakeX[0]--;
	if (direction == 3) snakeY[0]--;
		
	for (int d = 1; d < length; d ++)
		if(snakeX[d] == snakeX[0] && snakeY[d] == snakeY[0])
			length = d;
			
	}
}
