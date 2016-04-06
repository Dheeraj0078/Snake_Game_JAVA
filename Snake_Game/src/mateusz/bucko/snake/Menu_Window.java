package mateusz.bucko.snake;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu_Window extends JFrame implements ActionListener {

	private static JFrame main_Window;

	private JButton start_Game;

	public Menu_Window() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		main_Window = new JFrame("Snake Menu");
		main_Window.setLayout(null);
		main_Window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main_Window.setVisible(true);
		main_Window.setSize(800, 600);
		main_Window.setLocation(dimension.width / 2 - main_Window.getWidth() / 2,
				(int) (dimension.getHeight() / 2 - main_Window.getHeight() / 2));

		start_Game = new JButton("Start Game");
		start_Game.setBounds(50, 50, 100, 60);
		main_Window.add(start_Game);
		start_Game.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == start_Game) {
			new Snake(); 
		}

	}
	
}
