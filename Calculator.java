// Calculator class - handles all the math operations
public class Calculator {
    
    // Adds two numbers together
    public double add(double num1, double num2) {
        return num1 + num2;
    }
    
    // Subtracts the second number from the first number
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
    
    // Multiplies two numbers together
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    
    // Divides the first number by the second number
    public double divide(double num1, double num2) {
        // Check if the divisor is zero to prevent division by zero
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}
