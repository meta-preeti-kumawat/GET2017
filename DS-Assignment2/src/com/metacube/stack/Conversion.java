package com.metacube.stack;

import java.util.InputMismatchException;

public class Conversion {
	
	public String infixToPostfix(String expression){
		String postfix = "";
		char[] characters = expression.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		boolean valid = true;
		int properExpression = 0; 
		// 0 if invalid, 1 for single operand, 2 for operator, 3 for second operands, 4 for left brackets, 5 for right brackets 
		
		valid = validateExpression(expression);
		if(!valid){
			throw new InputMismatchException("Input String is not valid");
		}
		for (int loop = 0; loop < characters.length; loop++) {
			valid = true;
			if(!Character.isSpaceChar(characters[loop])){
				Type type = getCharacterType(characters[loop]);
				
				if(type.equals(Type.INVALID)){
					throw new InputMismatchException("Input String does not contains valid characters");
				}
				if(type.equals(Type.OPERAND)){
					postfix += characters[loop];
					if(properExpression == 2){
						properExpression = 3;
					}
					else if(properExpression == 0 || properExpression == 4){
						properExpression = 1;
					}
					else{
						properExpression = 0;
						valid = false;
						break;
					}
				}
				else if(type.equals(Type.OPERATOR)){
					if(properExpression == 1 || properExpression == 3 || properExpression == 5){
						properExpression = 2;
						if(getPrecedence(characters[loop]) == 0){
							throw new InputMismatchException("Operator seems to be invalid");
						}
						if(stack.isEmpty() || getCharacterType(stack.getPeek()).equals(Type.LBRACKET) 
								|| getCharacterType(stack.getPeek()).equals(Type.RBRACKET)){
							stack.push(characters[loop]);
						}
						else if(getPrecedence(stack.getPeek()) >= getPrecedence(characters[loop])){
							postfix += stack.pop();
							stack.push(characters[loop]);
						}
						else{
							stack.push(characters[loop]);
						}
					}
					else{
						properExpression = 0;
						valid = false;
						break;
					}
				}
				else if(type.equals(Type.LBRACKET)){
					if(properExpression == 0 || properExpression == 2 || properExpression == 4){
						properExpression = 4;
						stack.push(characters[loop]);
					}
					else{
						properExpression = 0;
						valid = false;
						break;
					}
				}
				else if(type.equals(Type.RBRACKET)){
					if(properExpression == 3){
						properExpression = 5;
						postfix += popUntilLeftBracket(stack, characters[loop]);
					}
					else{
						properExpression = 0;
						valid = false;
						break;
					}
				}
			}
				
		}
		if(!valid){
			throw new InputMismatchException("Input String is not a valid expression");
		}
		
		while(!stack.isEmpty()){
			postfix += stack.pop();
		}
		return postfix;
	}

	private String popUntilLeftBracket(Stack<Character> stack, char character) {
		String expression = "";
		boolean check = true;
		while(!getCharacterType(stack.getPeek()).equals(Type.LBRACKET)){
			expression += stack.pop();
		}
		if(getCharacterType(stack.getPeek()).equals(Type.LBRACKET)){
			switch (character) {
			
				case ']':
					if(!stack.isEmpty()){
						if(stack.pop() != '['){
							check = false;
						}
					}
					else{
						check = false;
					}
					break;
				
				case '}':
					if(!stack.isEmpty()){
						if(stack.pop() != '{'){
							check = false;
						}
					}
					else{
						check = false;
					}
					break;
				case ')':
					if(!stack.isEmpty()){
						if(stack.pop() != '('){
							check = false;
						}
					}
					else{
						check = false;
					}
					break;
	
				default:
					break;
			}
		}
		if(check == false){
			throw new InputMismatchException("Brackets are improper");
		}
		return expression;
	}

	private int getPrecedence(Character operator) {
		int precedence = 0;
		switch (operator) {
		case '^':
			precedence = 3;
			break;
		case '*':
			precedence = 2;
			break;
		case '/':
			precedence = 2;
			break;
		case '%':
			precedence = 2;
			break;
		case '+':
			precedence = 1;
			break;
		case '-':
			precedence = 1;
			break;

		default:
			precedence = 0;
			break;
		}
		return precedence;
	}

	private boolean validateExpression(String expression) {
		Stack<Character> stack = new Stack<Character>();
		char character;
		boolean check = true;
		
		for(int loop = 0; loop < expression.length(); loop++){
			character = expression.charAt(loop);
			switch (character) {
			case '(':
				stack.push(character);
				break;
 
			case '{':
				stack.push(character);
				break;
			
			case '[':
				stack.push(character);
				break;
			
			case ']':
				if(!stack.isEmpty()){
					if(stack.pop() != '['){
						check = false;
					}
				}
				else{
					check = false;
				}
				break;
			
			case '}':
				if(!stack.isEmpty()){
					if(stack.pop() != '{'){
						check = false;
					}
				}
				else{
					check = false;
				}
				break;
			case ')':
				if(!stack.isEmpty()){
					if(stack.pop() != '('){
						check = false;
					}
				}
				else{
					check = false;
				}
				break;

			default:
				break;
			}
		}
		return check;
	}

	private Type getCharacterType(char character) {
		if(Character.isLetter(character)){
			return Type.OPERAND;
		}
		else if(character == '+' || character == '-'  || character == '*'  
				|| character == '/'  || character == '%'  || character == '^' ){
			return Type.OPERATOR;
		}
		else if(character == '(' || character == '[' || character == '{') {
			return Type.LBRACKET;
		}
		else if( character == '}' || character == ')' || character == ']'){
			return Type.RBRACKET; 
		}
		else {
			return Type.INVALID;
		}
	}
}
