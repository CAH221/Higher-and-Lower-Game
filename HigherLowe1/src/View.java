//****************************************************//
//* Author:1717859                                    *//
//* Week:2                                            *//
//*                                                   *//
//* Description: View class for the HigherLower game, *//
//*              responsible for creating the GUI,    *//
//*              handling user input, and displaying  *//
//*              messages based on the user's guesses.*//
//*                                                   *//
//* Date: 06/10/2024                                  *//
//****************************************************//
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// View class to handle the graphical user interface (GUI)
public class View {
    Frame frmMain = new Frame();      // Main window (frame)
    Button btnGo = new Button("Go");  // Button to submit the guess
    Label lblMessage = new Label("Guess a number between 1 and 100");  // Label to show messages
    TextField txtGuess = new TextField("", 10);  // Text field for user to input their guess
    Model secretModel;  // Reference to the model (secret number generator)

    // Constructor for the View, initializes the window and components
    public View(Model model) {
        secretModel = model;  // Store the reference to the model

        // Set up the window (frame)
        frmMain.setSize(400, 300);  // Set the size of the window
        frmMain.setTitle("Higher Lower Game");  // Set the title of the window

        // Position and add the label to the window
        lblMessage.setBounds(20, 50, 360, 30);
        frmMain.add(lblMessage);

        // Position and add the text field to the window
        txtGuess.setBounds(20, 100, 100, 30);
        frmMain.add(txtGuess);

        // Position and add the button to the window
        btnGo.setBounds(140, 100, 50, 30);
        frmMain.add(btnGo);

        // Use null layout, which allows absolute positioning of components
        frmMain.setLayout(null);
        frmMain.setVisible(true);  // Make the window visible

        // Add an ActionListener to the "Go" button to handle the click event
        btnGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleGuess();  // Call handleGuess() when the button is clicked
            }
        });

        // Handle the window close event to exit the program when the window is closed
        frmMain.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);  // Close the application
            }
        });
    }

    // Method to handle the logic when the user submits a guess
    public void handleGuess() {
        try {
            // Convert the text input into an integer
            int userGuess = Integer.parseInt(txtGuess.getText());

            // Compare the user's guess with the secret number
            if (userGuess > secretModel.getSecret()) {
                tooHigh(userGuess);  // Guess is too high
            } else if (userGuess < secretModel.getSecret()) {
                tooLow(userGuess);   // Guess is too low
            } else {
                win(userGuess);      // Guess is correct
            }
        } catch (NumberFormatException ex) {
            // If the input is not a valid number, display an error message
            lblMessage.setText("Please enter a valid number.");
        }

        // Clear the input field after each guess
        txtGuess.setText("");
    }

    // Display a message when the user's guess is too high
    public void tooHigh(int guess) {
        lblMessage.setText("You guessed " + guess + " which is too high. Try again!");
    }

    // Display a message when the user's guess is too low
    public void tooLow(int guess) {
        lblMessage.setText("You guessed " + guess + " which is too low. Try again!");
    }

    // Display a message when the user guesses the correct number and reset the game
    public void win(int guess) {
        lblMessage.setText("Congratulations! You guessed the secret number " + guess);
        secretModel = new Model();  // Reset the game with a new secret number
    }
}