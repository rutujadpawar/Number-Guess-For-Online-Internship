import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessGameUI extends JFrame implements ActionListener {
    private int targetNumber;
    private JTextField guessField;
    private JLabel resultLabel;

    public NumberGuessGameUI() {
        // Frame setup
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BorderLayout());

        // Generate a random number between 1 and 100
        targetNumber = (int) (Math.random() * 100) + 1;

        // Instruction Label
        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        add(instructionLabel, BorderLayout.NORTH);

        // Guess Field
        guessField = new JTextField();
        guessField.addActionListener(this);
        add(guessField, BorderLayout.CENTER);

        // Result Label
        resultLabel = new JLabel("");
        add(resultLabel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int userGuess = Integer.parseInt(guessField.getText());

            if (userGuess < 1 || userGuess > 100) {
                resultLabel.setText("Please enter a number between 1 and 100.");
            } else {
                if (userGuess < targetNumber) {
                    resultLabel.setText("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    resultLabel.setText("Too high! Try again.");
                } else {
                    resultLabel.setText("Congratulations! You guessed the correct number.");
                    guessField.setEditable(false);  // Disable further input after correct guess
                }
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberGuessGameUI guessGame = new NumberGuessGameUI();
            guessGame.setVisible(true);
        });
    }
}
