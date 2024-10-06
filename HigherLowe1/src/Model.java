//****************************************************//
//* Author:1717859                                    *//
//* Week:2                                            *//
//*                                                   *//
//* Description: Model class for the HigherLower game, *//
//*              which is responsible for generating  *//
//*              and storing the secret random number *//
//*              that the user has to guess.          *//
//*                                                   *//
//* Date: 06/10/2024                                  *//
//****************************************************//
import java.util.Random;

// Model class that holds the secret number
public class Model {
    private int randNum;  // Store the secret number

    // Constructor to generate a new secret number when an object is created
    public Model() {
        setSecret();  // Initialize the secret number
    }

    // Method to generate a random number between 1 and 100
    private void setSecret() {
        Random rand = new Random();   // Create a Random object
        int upperbound = 100;         // Upper bound for the random number
        this.randNum = rand.nextInt(upperbound) + 1;  // Generate the random number (1 to 100)
    }

    // Getter method to return the secret number
    public int getSecret() {
        return randNum;
    }

    // Optional method for debugging
    public String toString() {
        return "Generates a secret number";
    }
}
