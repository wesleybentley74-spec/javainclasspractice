// Division operation
public class DivideOperation implements Operation {
    
    @Override
    public double execute(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return operand1 / operand2;
    }
    
    @Override
    public String getName() {
        return "Division";
    }
    
    @Override
    public String getSymbol() {
        return "/";
    }
}
