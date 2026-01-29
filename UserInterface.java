//The user interface code

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
    
    // Method to get the user's menu choice
    public int getMenuChoice() {
        System.out.print("Choose (1-5): "); // Prompt the user to choose an option
        
        // Validate that the input is an integer
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            scanner.nextLine(); // consume invalid input
            return -1; // Return -1 to indicate invalid input
        }
        
        return scanner.nextInt(); // Get and return the user's choice
    }
    
    // Method to close the scanner
    public void close() {
        scanner.close();
    }
}
