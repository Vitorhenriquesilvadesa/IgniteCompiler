package org.ignitescript.compiler.lexer.expression;

public class VariableOperand extends Operand {

    private final String variableName;

    public VariableOperand(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public boolean evaluate() {
        return false;
    }
}
