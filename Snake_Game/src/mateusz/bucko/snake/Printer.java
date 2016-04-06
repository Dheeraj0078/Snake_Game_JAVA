package mateusz.bucko.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Printer extends JPanel{
	protected void paintComponent(Graphics g) {
	
		repaint();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Snake.getGameWindow().getWidth(), Snake.getGameWindow().getHeight());
		g.setColor(Color.white);
		for(Point p : Snake.getSnakeBody())
		{
			g.fillRect(p.x * Snake.SIZE ,p.y * Snake.SIZE , Snake.SIZE ,Snake.SIZE );
		}
		g.fillRect(Snake.getSnakeHead().x * Snake.SIZE, Snake.getSnakeHead().y * Snake.SIZE, Snake.SIZE, Snake.SIZE);
		
		g.setColor(Color.ORANGE);
		g.fillRect(Snake.get_food_possision().x * Snake.SIZE, Snake.get_food_possision().y * Snake.SIZE, Snake.SIZE, Snake.SIZE);
	}
	}


