package com.gl.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

public class BracketsBalancingParser {

	static boolean areBracketsBalanced(String expr) {
		Deque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < expr.length(); i++) {
			char character = expr.charAt(i);

			if (character == '(' || character == '[' || character == '{') {
				stack.push(character);
				continue;
			}

			if (stack.isEmpty())
				return false;
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

		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		String expr = "([[{}]])";

		if (areBracketsBalanced(expr))
			System.out.println("The entered String" + expr + " has Balanced Brackets");
		else
			System.out.println("The entered String " + expr + " do not contain Balanced Brackets ");

		expr = "([[{}]]))";

		if (areBracketsBalanced(expr))
			System.out.println("The entered String" + expr + " has Balanced Brackets");
		else
			System.out.println("The entered String " + expr + " do not contain Balanced Brackets ");

	}

}
