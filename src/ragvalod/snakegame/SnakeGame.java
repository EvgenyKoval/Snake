package ragvalod.snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import ragvalod.snakegame.objects.Apple;
import ragvalod.snakegame.objects.Snake;

public class SnakeGame extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int SCALE = 32;
	public static final int	WIDTH = 20;
	public static final int	HEIGHT = 20;
	public static final int SPEED = 5;
	
	Apple a = new Apple((int)((Math.random() * 100) % WIDTH), (int)((Math.random() * 100) % HEIGHT));
	Snake s = new Snake(10, 10, 9, 10);
	Timer t = new Timer(1000 / SPEED, this);
	
	public SnakeGame() {
		t.start();
		addKeyListener(new Keyboard());
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(color(15, 15, 70));
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		g.setColor(color(0, 255, 0));
		for (int x = 0; x <= WIDTH * SCALE; x += SCALE) {
			g.drawLine(x, 0, x, HEIGHT * SCALE);			
		}
		for (int y = 0; y <= HEIGHT * SCALE; y += SCALE) {
			g.drawLine(0, y, WIDTH * SCALE, y);
		}
		g.setColor(color(255, 0, 0));
		for (int d = 0; d < s.length; d++) {			
			g.fillRect(s.snakeX[d] * SCALE + 1,s.snakeY[d] * SCALE + 1,SCALE - 1,SCALE - 1);
			g.setColor(color(0, 0, 0));
		}
		g.setColor(color(255, 255, 255));
		g.drawString(String.valueOf(s.length), 10, 20);
		g.setColor(color(255, 216, 0));
		g.fillRect(a.positionX * SCALE + 1, a.positionY * SCALE + 1, SCALE - 1, SCALE - 1);
	}
	
	public Color color(int red, int green, int blue) {
		return new Color(red, green, blue);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(WIDTH * SCALE + 10, HEIGHT * SCALE + 31);
		f.setLocationRelativeTo(null);
		f.add(new SnakeGame());
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		s.move();
		if (s.snakeX[0] == a.positionX & s.snakeY[0] == a.positionY) {
			s.length++;
			a.setRandomPosition();
		}
		for (int i = 1; i < s.length; i++) {
			if (s.snakeX[i] == a.positionX & s.snakeY[i] == a.positionY) {
				a.setRandomPosition();
			}
		}
		repaint();
	}

	private class Keyboard extends KeyAdapter{
		public void keyPressed(KeyEvent kEvt){
			int key = kEvt.getKeyCode();
			
			if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) & s.direction != 2) s.direction = 0;
			if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) & s.direction != 3) s.direction = 1;
			if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) & s.direction != 0) s.direction = 2;
			if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) & s.direction != 1) s.direction = 3;
			if (key == KeyEvent.VK_P) t.stop(); 
			if (key == KeyEvent.VK_R) t.start(); 
		}
	}
}
