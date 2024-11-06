package guessingGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class guessingGame {

	private JFrame mainWindow;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guessingGame window = new guessingGame();
					window.mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public guessingGame() {
		initialize();
	}
	
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setBounds(100, 100, 438, 710);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);
		
		JButton startButton = new JButton("Start");
		startButton.setFont(new Font("Porter Sans Block", Font.PLAIN, 16));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                mainWindow.setVisible(false);
                startGame gameWindow = new startGame();
                gameWindow.getMainWindow().setVisible(true);
            }
		});
		startButton.setBounds(120, 420, 180, 70);
		mainWindow.getContentPane().add(startButton);
		
		JLabel LineDesign = new JLabel("");
		LineDesign.setIcon(new ImageIcon("C:\\Users\\Maze\\Desktop\\PROGLAN PROJECT\\PythonPackage\\Line Design.png"));
		LineDesign.setBounds(281, 0, 141, 671);
		mainWindow.getContentPane().add(LineDesign);
		
		JLabel RandomNumbers = new JLabel("");
		RandomNumbers.setIcon(new ImageIcon("C:\\Users\\Maze\\Desktop\\PROGLAN PROJECT\\PythonPackage\\Random Numbers.png"));
		RandomNumbers.setBounds(-30, 420, 481, 361);
		mainWindow.getContentPane().add(RandomNumbers);
		
		JLabel GuessLbl = new JLabel("Guess");
		GuessLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GuessLbl.setFont(new Font("Porter Sans Block", Font.PLAIN, 26));
		GuessLbl.setBounds(120, 34, 180, 50);
		mainWindow.getContentPane().add(GuessLbl);
		
		JLabel TheLbl = new JLabel("The");
		TheLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TheLbl.setFont(new Font("Porter Sans Block", Font.PLAIN, 26));
		TheLbl.setBounds(120, 75, 180, 50);
		mainWindow.getContentPane().add(TheLbl);
		
		JLabel NumberLbl = new JLabel("Number");
		NumberLbl.setHorizontalAlignment(SwingConstants.CENTER);
		NumberLbl.setFont(new Font("Porter Sans Block", Font.PLAIN, 26));
		NumberLbl.setBounds(120, 120, 180, 50);
		mainWindow.getContentPane().add(NumberLbl);
	}
}
