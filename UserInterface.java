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



// Importing the Scanner class for user input
import java.util.Scanner;

// This class handles all the user input and output
public class UserInterface {
    private Scanner scanner; // Scanner instance for reading user input
    private Calculator calculator; // Calculator instance for performing calculations
    
    // Constructor to initialize the UserInterface
    public UserInterface() {
        scanner = new Scanner(System.in); 
        calculator = new Calculator(); 
    }
    
    // Method to display the calculator menu
    public void displayMenu() {
        System.out.println("\n--- Calculator Menu ---"); 
        System.out.println("1. Add"); 
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        System.out.println("----------------------");
    }
    
    // Method to prompt the user for a number with a custom message
    public double getNumber(String prompt) {
        System.out.print(prompt); 
        while (!scanner.hasNextDouble()) { 
            System.out.print("Invalid input. Try again: "); 
            scanner.nextLine(); 
        }
        return scanner.nextDouble(); 
    }
    
    // Method to perform the selected math operation
    public void performOperation(int choice) {
        try {
            // Get the numbers from the user
            double num1 = getNumber("First number: ");
            double num2 = getNumber("Second number: ");
            double result = 0; 
            String operationName = ""; 
            
            // Switch case to handle the selected operation
            switch (choice) {
                case 1:
                    result = calculator.add(num1, num2); // Addition
                    operationName = "Addition";
                    break;
                case 2:
                    result = calculator.subtract(num1, num2); // Subtraction
                    operationName = "Subtraction";
                    break;
                case 3:
                    result = calculator.multiply(num1, num2); // Multiplication
                    operationName = "Multiplication";
                    break;
                case 4:
                    result = calculator.divide(num1, num2); // Division
                    operationName = "Division";
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
                    return;
            }
            
            // Display the result of the operation
            displayResult(num1, num2, result, operationName);
        } catch (IllegalArgumentException e) {
            // Handle any illegal argument exceptions 
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Method to display the result of an arithmetic operation
    public void displayResult(double num1, double num2, double result, String operationName) {
        System.out.println("\nResult: " + result); // Display the result
    }
    
    // Method to display the welcome message
    public void displayWelcome() {
        System.out.println("\nWelcome to Calculator!"); // Welcome message
    }
    
    // Method to display the goodbye message
    public void displayGoodbye() {
        System.out.println("\nBye!"); // Goodbye message
    }
    
    // Method to start the user interface and handle user interactions
    public void start() {
        displayWelcome(); // Show the welcome message
        boolean running = true; // Flag to control the program loop
        
        // Main loop to keep the program running
        while (running) {
            displayMenu(); // Display the calculator menu
            System.out.print("Choose (1-5): "); // Prompt the user to choose an option
            
            // Validate that the input is an integer
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine(); // consume invalid input
                continue;
            }
            
            int choice = scanner.nextInt(); // Get the user's choice
            
            // Handle the user's choice
            if (choice == 5) {
                running = false; // Exit the loop if the user chooses to exit
            } else if (choice >= 1 && choice <= 4) {
                performOperation(choice); // Perform the selected operation
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }
        
        displayGoodbye(); // Show the goodbye message
        scanner.close(); // Close the scanner
    }
}
