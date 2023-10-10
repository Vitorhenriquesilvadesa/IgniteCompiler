package org.ignitescript.compiler.lexer.expression.logic;

import org.ignitescript.compiler.exceptions.InvalidBooleanOperatorException;
import org.ignitescript.compiler.exceptions.InvalidNegationUsageException;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public final class BooleanExpressionAnalyzer {

    public static boolean evaluate(String expression) {
        List<String> tokens = parse(expression);
        List<String> convertedTokens = convertToInfix(tokens);
        Stack<Boolean> stack = new Stack<>();

        for(int i = 0; i < tokens.size(); i++){
            if(tokens.get(i).equals("!")){
                if(!tokens.get(i + 1).equals("true") && !tokens.get(i + 1).equals("false")){
                    throw new InvalidNegationUsageException("Invalid negation usage: " + tokens.get(i) + tokens.get(i + 1) + ".");
                }
            }
        }

        for (int i = 0; i < tokens.size(); i++) {
            if (convertedTokens.get(i).equals("true") || convertedTokens.get(i).equals("false")) {
                stack.push(Boolean.parseBoolean(convertedTokens.get(i)));
            } else if (convertedTokens.get(i).equals("&&")) {
                boolean op2 = stack.pop();
                boolean op1 = stack.pop();
                stack.push(op1 && op2);
            } else if (convertedTokens.get(i).equals("||")) {
                boolean op2 = stack.pop();
                boolean op1 = stack.pop();
                stack.push(op1 || op2);
            } else if (convertedTokens.get(i).equals("!")) {

                if(stack.isEmpty()){
                    throw new InvalidNegationUsageException("Invalid negation usage: " + tokens.get(i) + (stack.isEmpty() ? null : stack.peek()) + ".");
                }

                if ((stack.peek().toString().equals("true") || stack.peek().toString().equals("false"))) {
                    stack.push(!stack.pop());
                }

            } else {
                throw new InvalidNegationUsageException("Invalid negation usage: " + tokens.get(i) + stack.peek() + ".");
            }

        }

        return stack.pop();
    }

    private static List<String> parse(String expression) throws ClassCastException {

        int i = 0;
        List<String> tokens = new ArrayList<>();

        while (i < expression.length()) {

            char c = expression.charAt(i);

            if (c == '&') {
                if (expression.charAt(i + 1) == '&') {
                    tokens.add("&&");
                    i++;
                } else {
                    throw new InvalidBooleanOperatorException("Unknow boolean operator: " + c);
                }

            } else if (c == 'A') {
                if (expression.startsWith("AND", i)) {
                    tokens.add("&&");
                    i += 2;
                } else {
                    throw new InvalidBooleanOperatorException("Unknow boolean operator: " + c);
                }

            } else if (c == '|') {
                if (expression.charAt(i + 1) == '|') {
                    tokens.add("||");
                    i++;
                } else {
                    throw new InvalidBooleanOperatorException("Unknow boolean operator: " + c);
                }

            } else if (c == 'O') {
                if (expression.startsWith("OR", i)) {
                    tokens.add("||");
                    i++;
                } else {
                    throw new InvalidBooleanOperatorException("Unknow boolean operator: " + c);
                }

            } else if (c == '!') {
                tokens.add("!");

            } else if (c == '(') {
                tokens.add("(");

            } else if (c == ')') {
                tokens.add(")");

            } else if (c == 'N') {

                if (expression.startsWith("NOT", i)) {
                    tokens.add("!");
                }

            } else if (c == 't') {

                if (expression.startsWith("true", i)) {
                    tokens.add("true");
                    i += 3;
                } else {
                    throw new InvalidBooleanOperatorException("Unknow boolean operator: " + c);
                }

            } else if (c == 'f') {

                if (expression.startsWith("false", i)) {
                    tokens.add("false");
                    i += 4;
                } else {
                    throw new InvalidBooleanOperatorException("Unknow boolean operator: " + c);
                }
            } else if (c != ' ' && c != '\n' && c != '\t') {
                throw new InvalidBooleanOperatorException("Unknow boolean operator: " + c);
            }

            i++;
        }

        return tokens;
    }

    private static int precedence(String operator) {
        return switch (operator) {
            case "||" -> 1;
            case "&&" -> 2;
            case "!" -> 3;
            case "(", ")" -> 4;
            default -> -1;
        };
    }

    private static List<String> convertToInfix(List<String> tokens) {

        List<String> result = new ArrayList<>();

        Stack<String> operandsStack = new Stack<>();
        Stack<String> operatorsStack = new Stack<>();

        for (int i = 0; i < tokens.size(); i++) {

            if (tokens.get(i).equals("true") || tokens.get(i).equals("false")) {
                result.add(tokens.get(i));

            } else if (!operatorsStack.isEmpty() && !tokens.get(i).equals("(") && !tokens.get(i).equals(")") && precedence(tokens.get(i)) <= precedence(operatorsStack.peek())) {
                if (!operatorsStack.peek().equals("(")) {
                    result.add(operatorsStack.pop());
                }
                operatorsStack.push(tokens.get(i));

            } else if (!tokens.get(i).equals(")")) {
                operatorsStack.push(tokens.get(i));

            } else if (tokens.get(i).equals(")")) {

                while (!operatorsStack.peek().equals("(")) {
                    result.add(operatorsStack.pop());
                }
                if (operatorsStack.peek().equals("(")) {
                    operatorsStack.pop();
                }
            }
        }

        while (!operatorsStack.isEmpty()) {
            if (!operatorsStack.peek().equals("(") && !operatorsStack.peek().equals(")")) {
                result.add(operatorsStack.pop());
            }
        }

        return result;
    }
}