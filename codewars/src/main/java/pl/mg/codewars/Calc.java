package pl.mg.codewars;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Your job is to create a calculator which evaluates expressions in Reverse
 * Polish notation.
 * 
 * For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2)
 * * 4) - 3 in normal notation) should evaluate to 14.
 * 
 * Note that for simplicity you may assume that there are always spaces between
 * numbers and operations, e.g. 1 3 + expression is valid, but 1 3+ isn't.
 * 
 * Empty expression should evaluate to 0.
 * 
 * Valid operations are +, -, *, /.
 * 
 * You may assume that there won't be exceptional situations (like stack
 * underflow or division by zero).
 * 
 * @author Kacper
 *
 */
public class Calc {

	private LinkedList<Double> stack = new LinkedList<Double>();

	public static void main(String[] args) {
		Calc calc = new Calc();
		calc.evaluateOnStack("1 2 +");
	}

	public double evaluate(String expr) {

		if (expr == null || expr.length() == 0) {
			return 0;
		}
		String[] characters = expr.split(" ");
		Double result = 0.0;

		// pattern do wykrycia operacji
		String patternOperation = "[\\+\\/\\-\\*]";
		Pattern pattern = Pattern.compile(patternOperation);

		for (String charek : characters) {
			if (pattern.matcher(charek).matches()) {
				Double secondValue = stack.removeLast();
				Double firstValue = stack.removeLast();
				stack.addLast(calc(firstValue, secondValue, charek));
			} else {
				stack.addLast(Double.parseDouble(charek));
				System.out.println("add char " + charek);
			}
		}
		result = stack.removeLast();
		// System.out.println(result);

		return result;
	}

	public double evaluateOnStack(String expr) {
		if (expr == null || expr.length() == 0) {
			return 0;
		}
		String[] characters = expr.split(" ");

		Stack<Double> stack = new Stack<Double>();

		for (String charek : characters) {
			double var;

			switch (charek) {
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				var = stack.pop();
				stack.push(stack.pop() - var);
				break;
			case "*":
				var = stack.pop();
				stack.push(stack.pop() * var);
				break;
			case "/":
				var = stack.pop();
				stack.push(stack.pop() / var);
				break;
			default:
				stack.push(Double.parseDouble(charek));
				break;
			}
		}
		double result = stack.pop();
		System.out.println(result);
		return (int) result;
	}

	public Double calc(Double first, Double second, String operator) {
		Double resultInteger = 0.0;
		switch (operator) {
		case "+":
			resultInteger = first + second;
			break;
		case "-":
			resultInteger = first - second;
			break;
		case "*":
			resultInteger = first * second;
			break;
		case "/":
			resultInteger = first / second;
			break;
		default:
			resultInteger = 0.0;
			break;
		}
		return resultInteger;
	}

}
