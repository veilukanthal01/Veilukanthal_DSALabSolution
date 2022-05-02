package com.gl.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

public class BracketsBalancingParser {

	static boolean checkingBracketsBalanced(String expr) {
		Deque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < expr.length(); i++) {
			char character = expr.charAt(i);

			// If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push
			// it to stack and continue with the next iteration
			if (character == '(' || character == '[' || character == '{') {
				stack.push(character);
				continue;
			}

			// If current character is not opening bracket, then it must be closing. So
			// stack cannot be empty at this point
			// Example Expression: (([[{}]])
			// Case : redundant closing bracket(s)
			if (stack.isEmpty())
				return false;

			// If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop
			// from stack and if the popped character is the matching starting bracket then
			// fine else brackets are not balanced.
			// Example Expression: (([[{}}])
			char check;
			switch (character) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// After complete traversal, if there is some starting bracket left in stack
		// then “not balanced”
		// Example Expression: (([[{}]])
		// Case : redundant Opening bracket(s)
		return (stack.isEmpty());
	}

	
	public static void main(String[] args) {
		String expr = "([[{}]])";

		if (checkingBracketsBalanced(expr))
			System.out.println("The entered String" + expr + " has Balanced Brackets");
		else
			System.out.println("The entered String " + expr + " do not contain Balanced Brackets ");

		expr = "(([[{}]])";

		if (checkingBracketsBalanced(expr))
			System.out.println("The entered String" + expr + " has Balanced Brackets");
		else
			System.out.println("The entered String " + expr + " do not contain Balanced Brackets ");

	}

}
