/*
Wesley Bentley
CIST 211
Doctor G
Purpose of the assignment is to increase OOP and readability

First I am going to change a bunch of the code into methods to make it more readable.
Then I am going to create a UserInterface class to handle all user input and output.
Finally I am going to create a Calculator class to handle all the math operations.
With each I will move the methods to their respective classes.
 */

// Main class - starts the calculator and handles the main loop
public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        
        ui.displayWelcome(); // Show the welcome message
        boolean running = true; // Flag to control the program loop
        
        // Main loop to keep the program running
        while (running) {
            ui.displayMenu(); // Display the calculator menu
            int choice = ui.getMenuChoice(); // Get the user's menu choice
            
            // Handle the user's choice
            if (choice == -1) {
                continue; // Skip to next iteration if invalid input
            } else if (choice == 5) {
                running = false; // Exit the loop if the user chooses to exit
            } else if (choice >= 1 && choice <= 4) {
                ui.performOperation(choice); // Perform the selected operation
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }
        
        ui.displayGoodbye(); // Show the goodbye message
        ui.close(); // Close the scanner
    }
}
