import java.util.Scanner;

// This class handles all the user input and output
public class UserInterface {
    private Scanner scanner;
    private Calculator calculator;
    
    public UserInterface() {
        scanner = new Scanner(System.in);
        calculator = new Calculator();
    }
    
    private void displayMenu() {
        System.out.println("\n--- Calculator Menu ---");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        System.out.println("----------------------");
    }
    
    private double getNumber(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Try again: ");
            scanner.nextLine();
        }
        return scanner.nextDouble();
    }
    
    private void performOperation(int choice) {
        try {
            double num1 = getNumber("First number: ");
            double num2 = getNumber("Second number: ");
            double result = 0;
            String operationName = "";
            
            switch (choice) {
                case 1:
                    result = calculator.add(num1, num2);
                    operationName = "Addition";
                    break;
                case 2:
                    result = calculator.subtract(num1, num2);
                    operationName = "Subtraction";
                    break;
                case 3:
                    result = calculator.multiply(num1, num2);
                    operationName = "Multiplication";
                    break;
                case 4:
                    result = calculator.divide(num1, num2);
                    operationName = "Division";
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
                    return;
            }
            
            displayResult(num1, num2, result, operationName);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void displayResult(double num1, double num2, double result, String operationName) {
        System.out.println("\nResult: " + result);
    }
    
    private void displayWelcome() {
        System.out.println("\nWelcome to Calculator!");
    }
    
    private void displayGoodbye() {
        System.out.println("\nBye!");
    }
    
    public void start() {
        displayWelcome();
        boolean running = true;
        
        while (running) {
            displayMenu();
            System.out.print("Choose (1-5): ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine(); // consume invalid input
                continue;
            }
            
            int choice = scanner.nextInt();
            
            if (choice == 5) {
                running = false;
            } else if (choice >= 1 && choice <= 4) {
                performOperation(choice);
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }
        
        displayGoodbye();
        scanner.close();
    }
}
