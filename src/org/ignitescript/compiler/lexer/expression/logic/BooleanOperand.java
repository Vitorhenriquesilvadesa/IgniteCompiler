package org.ignitescript.compiler.lexer.expression.logic;

import org.ignitescript.compiler.lexer.expression.Operand;

public class BooleanOperand extends Operand {

    private final boolean value;

    public BooleanOperand(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate() {
        return value;
    }
}
