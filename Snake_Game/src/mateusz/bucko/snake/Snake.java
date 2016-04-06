package mateusz.bucko.snake;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Snake extends JFrame implements ActionListener, KeyListener {

	private static JFrame game_Window;
	private Dimension dimension;
	private Printer printer = new Printer();
	private Timer timer = new Timer(30, this);
	private static final int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;
	private int snake_legth, direction = DOWN;
	public static int SIZE = 5;
	private static ArrayList<Point> snake_Body = new ArrayList<Point>();
	private static Point snake_Head;
	private static Point food;
	private boolean game_over, game_paused;
	private Random r;

	public Snake() {
		game_over = false;
		game_Window = new JFrame("Snake");
		game_Window.setSize(800, 600);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		game_Window.setLocation(dimension.width / 2 - game_Window.getWidth() / 2,
				(int) (dimension.getHeight() / 2 - game_Window.getHeight() / 2));
		game_Window.setVisible(true);
		game_Window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		game_Window.addKeyListener(this);
		game_Window.add(printer);
		snake_Body.clear();
		snake_Head = new Point(0, 0);
		food = new Point(50,50);
		snake_legth = 10;
		timer.start();

	}

	public static ArrayList<Point> getSnakeBody() {
		return snake_Body;
	}

	public static Point getSnakeHead() {
		return snake_Head;
	}

	public static JFrame getGameWindow() {
		return game_Window;
	}

	private boolean snake_in_possision(int x, int y) {
		for (Point p : snake_Body) {
			if (p.equals(new Point(x,y))) {
				return true;
			}
		}
		return false;
	}
	public static Point get_food_possision()
	{
		return food;
	}
	


	public void actionPerformed(ActionEvent e) {
		printer.repaint();

		if (!game_over) {
			snake_Body.add(snake_Head);
			if (direction == UP) {
				if (snake_Head.y - 1 >= 0 && !snake_in_possision(snake_Head.x, snake_Head.y - 1)) {
					snake_Head = new Point(snake_Head.x, snake_Head.y - 1);
				} else
					game_over = true;
			}
			
			if (direction == DOWN) {
				if (snake_Head.y + 1 <= game_Window.getHeight() / SIZE - 1
						&& !snake_in_possision(snake_Head.x, snake_Head.y + 1)) {
					snake_Head = new Point(snake_Head.x, snake_Head.y + 1);
				} else
					game_over = true;
			}
			
			if (direction == LEFT) {
				if (snake_Head.x - 1 >= 0 && !snake_in_possision(snake_Head.x - 1, snake_Head.y)) {
					snake_Head = new Point(snake_Head.x - 1, snake_Head.y);
				} else
					game_over = true;
			}

			if (direction == RIGHT) {
				if (snake_Head.x + 1 <= game_Window.getWidth() / SIZE - 1
						&& !snake_in_possision(snake_Head.x + 1, snake_Head.y)) {
					snake_Head = new Point(snake_Head.x + 1, snake_Head.y);
				} else
					game_over = true;
			}
			
			if (snake_Body.size() > snake_legth) {
				snake_Body.remove(0);
			}

			if (food != null) {
				if (snake_Head.equals(food)) {
					snake_legth++;
					r = new Random();
					food = new Point (r.nextInt((game_Window.getWidth()-1) / SIZE),r.nextInt((game_Window.getHeight()-50)/ SIZE));
				}
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && direction != DOWN) {
			direction = UP;
			System.out.println("UP");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && direction != UP) {
			direction = DOWN;
			System.out.println("DOWN");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && direction != RIGHT) {
			direction = LEFT;
			System.out.println("LEFT");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && direction != LEFT) {
			direction = RIGHT;
			System.out.println("RIGHT");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
