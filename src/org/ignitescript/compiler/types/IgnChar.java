package org.ignitescript.compiler.types;

import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

public class IgnChar extends IgnPrimitiveTypeImpl<Character>{

    protected IgnChar(Character value) {
        super(value);
    }

    @Override
    public NativeType getJavaType() {
        return null;
    }

    @Override
    public void setValue(String value) {
        if (value.length() == 1) {
            this.value = value.charAt(0);
        } else {
            throw new IgnInvalidArgumentException("Invalid char value: " + value);
        }
    }
}
