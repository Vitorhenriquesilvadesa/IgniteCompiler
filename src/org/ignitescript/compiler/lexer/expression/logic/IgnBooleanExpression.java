package org.ignitescript.compiler.lexer.expression.logic;

import org.ignitescript.compiler.lexer.expression.Operand;

public class IgnBooleanExpression extends Operand {

    private Operand leftOperand;
    private Operand rightOperand;
    private LogicalOperator operator;

    public IgnBooleanExpression(Operand leftOperand, LogicalOperator operator, Operand rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public IgnBooleanExpression(LogicalOperator operator, Operand expression) {
        this.leftOperand = expression;
        this.operator = operator;
    }

    public boolean evaluate() {
        if (operator == null) {
            if (leftOperand != null) {
                return leftOperand.evaluate();
            } else {
                return false;
            }
        } else {
            switch (operator) {
                case AND:
                    return and();
                case OR:
                    return or();

                case NOT:
                    return not();

                default:
                    throw new IllegalArgumentException("Unknown operator: " + operator);
            }
        }
    }

    private boolean or() {
        return leftOperand.evaluate() || rightOperand.evaluate();
    }

    private boolean and() {
        return leftOperand.evaluate() && rightOperand.evaluate();
    }

    private boolean not(){
        return !leftOperand.evaluate();
    }

    public void setLeftOperand(Operand leftOperand) {
        this.leftOperand = leftOperand;
    }


    public void setRightOperand(Operand rightOperand) {
        this.rightOperand = rightOperand;
    }


    public void setOperator(LogicalOperator operator) {
        this.operator = operator;
    }
}