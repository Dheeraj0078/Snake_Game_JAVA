package mateusz.bucko.snake;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Snake extends JFrame implements ActionListener, KeyListener{
	
	JFrame game_Window;
	private Dimension dimension;
	public Timer timer = new Timer(10, this);
	private static final int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;
	private int snake_legth, direction = DOWN , SIZE = 5;
	private ArrayList<Point> snake_Body = new ArrayList<Point>();
	private Point snake_Head, food;
	private boolean game_over , game_paused;
	Random r;
	
	
	
	
	public Snake() {
		game_Window = new JFrame("Snake");
		game_Window.setLocation(dimension.width / 2 - game_Window.getWidth() / 2,
				(int) (dimension.getHeight() / 2 - game_Window.getHeight() / 2));
		game_Window.setVisible(true);
		game_Window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		game_Window.setSize(800, 600);
		
	}
	
	public ArrayList<Point> getSnakeBody()
	{
		return snake_Body;
	}
	public Point getSnakeHead()
	{
		return snake_Head;
	}
	
	private boolean snake_in_possision(int x , int y)
	{
		for(Point p : snake_Body)
		{
			if(snake_Body.equals(p))
			{
				return true;
			}
		}
		return false;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(!game_over)
		{
			snake_Body.add(snake_Head);
			if(direction == UP)
			{
				if(snake_Head.y-1 >=0 && !snake_in_possision(snake_Head.x, snake_Head.y-1))
				{
					snake_Head = new Point(snake_Head.x,snake_Head.y-1);
				}
			}
			if(direction == DOWN)
			{
				if(snake_Head.y+1 <= game_Window.getHeight()-1 && !snake_in_possision(snake_Head.x, snake_Head.y+1))
				{
					snake_Head = new Point(snake_Head.x,snake_Head.y+1);
				}
			}
			if(direction == LEFT)
			{
				if(snake_Head.x-1 >=0 && !snake_in_possision(snake_Head.x-1, snake_Head.y))
				{
					snake_Head = new Point(snake_Head.x-1,snake_Head.y);
				}
			}
			
			if(direction == RIGHT)
			{
				if(snake_Head.x+1 <= game_Window.getWidth()-1 && !snake_in_possision(snake_Head.x+1, snake_Head.y))
				{
					snake_Head = new Point(snake_Head.x+1,snake_Head.y);
				}
			}
			if(snake_Body.size()>snake_legth)
			{
				snake_Body.remove(0);
			}
			
			}
		snake_legth++;
			
			
		}
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
