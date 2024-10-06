//****************************************************//
//* Author:1717859                                    *//
//* Week:2                                            *//
//*                                                   *//
//* Description: Main class for the HigherLower game, *//
//*              which includes generating a secret   *//
//*              number, creating the game view, and  *//
//*              setting up the model for user        *//
//*              interaction through a graphical      *//
//*              user interface (GUI).                *//
//*                                                   *//
//* Date: 06/10/2024                                  *//
//****************************************************//
import java.util.Random;      // Import Random class for generating the secret number
import javax.swing.*;         // Import Swing components for GUI
import java.awt.*;            // Import AWT components for layout and windowing
import java.awt.event.*;      // Import AWT event handling components

// Main class to run the game
class HigherLower {
    public static void main(String[] args) {
        Model secret = new Model();  // Create the secret number model
        View display = new View(secret);  // Create the view and pass the model to it
    }
}
