package guessingGame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class startGame {

    private JFrame gameWindow;
    private JTextField textField;
    private int randomNumber;

    public startGame() {
        initialize();
    }

    public JFrame getMainWindow() {
        return gameWindow;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    startGame window = new startGame();
                    window.gameWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initialize() {
        randomNumber = (int) (Math.random() * 10) + 1;

        gameWindow = new JFrame();
        gameWindow.setBounds(100, 100, 438, 710);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setLayout(null);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Porter Sans Block", Font.PLAIN, 16));
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userGuessText = textField.getText();
                
                try {
                    int userGuess = Integer.parseInt(userGuessText);

                    if (userGuess == randomNumber) {
                        JOptionPane.showMessageDialog(gameWindow, "Correct! You've guessed the number.", "Result", JOptionPane.INFORMATION_MESSAGE);
                        randomNumber = (int) (Math.random() * 10) + 1;
                    } else {
                        JOptionPane.showMessageDialog(gameWindow, "Wrong! Try again.", "Result", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(gameWindow, "Please enter a valid number between 1 and 10.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        submitButton.setBounds(140, 530, 180, 70);
        gameWindow.getContentPane().add(submitButton);

        JLabel GuessLbl = new JLabel("Guess");
        GuessLbl.setHorizontalAlignment(SwingConstants.CENTER);
        GuessLbl.setFont(new Font("Porter Sans Block", Font.PLAIN, 26));
        GuessLbl.setBounds(140, 34, 180, 50);
        gameWindow.getContentPane().add(GuessLbl);

        JLabel TheLbl = new JLabel("The");
        TheLbl.setHorizontalAlignment(SwingConstants.CENTER);
        TheLbl.setFont(new Font("Porter Sans Block", Font.PLAIN, 26));
        TheLbl.setBounds(140, 75, 180, 50);
        gameWindow.getContentPane().add(TheLbl);

        JLabel NumberLbl = new JLabel("Number");
        NumberLbl.setHorizontalAlignment(SwingConstants.CENTER);
        NumberLbl.setFont(new Font("Porter Sans Block", Font.PLAIN, 26));
        NumberLbl.setBounds(140, 120, 180, 50);
        gameWindow.getContentPane().add(NumberLbl);

        JLabel FromLbl = new JLabel("From");
        FromLbl.setHorizontalAlignment(SwingConstants.CENTER);
        FromLbl.setFont(new Font("Porter Sans Block", Font.PLAIN, 26));
        FromLbl.setBounds(140, 160, 180, 50);
        gameWindow.getContentPane().add(FromLbl);

        JLabel ToLbl = new JLabel("1 TO 10");
        ToLbl.setHorizontalAlignment(SwingConstants.CENTER);
        ToLbl.setFont(new Font("Porter Sans Block", Font.PLAIN, 26));
        ToLbl.setBounds(140, 201, 180, 50);
        gameWindow.getContentPane().add(ToLbl);

        textField = new JTextField();
        textField.setBounds(140, 430, 180, 70);
        gameWindow.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel LineDesign = new JLabel("");
        LineDesign.setIcon(new ImageIcon("C:\\Users\\Maze\\Desktop\\PROGLAN PROJECT\\PythonPackage\\Line Design.png"));
        LineDesign.setBounds(281, 0, 141, 671);
        gameWindow.getContentPane().add(LineDesign);

        JLabel RandomNumbers = new JLabel("");
        RandomNumbers.setIcon(new ImageIcon("C:\\Users\\Maze\\Desktop\\PROGLAN PROJECT\\PythonPackage\\Random Numbers.png"));
        RandomNumbers.setBounds(-30, 420, 481, 361);
        gameWindow.getContentPane().add(RandomNumbers);
    }
}
