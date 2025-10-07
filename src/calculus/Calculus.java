package calculus;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculus {
	public static void main(String[] args) {
        Expression e = new ExpressionBuilder("3 + 2 * sqrt(9)")
                .build();
        double result = e.evaluate();
        System.out.println("Rezultatul: " + result); // 9.0
    }
	
	public static double performCalculations(String expression) {
        Expression e = new ExpressionBuilder(expression)
                .build();
        double result = e.evaluate();
        
        return result;
	}
}
