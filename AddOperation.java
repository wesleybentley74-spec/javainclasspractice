// Addition operation
public class AddOperation implements Operation {
    
    @Override
    public double execute(double operand1, double operand2) {
        return operand1 + operand2;
    }
    
    @Override
    public String getName() {
        return "Addition";
    }
    
    @Override
    public String getSymbol() {
        return "+";
    }
}
