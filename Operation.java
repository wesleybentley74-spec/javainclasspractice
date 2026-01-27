// Interface for calculator operations
// makes it easy to add new operations
public interface Operation {
    
    double execute(double operand1, double operand2);
    String getName();
    String getSymbol();
}
