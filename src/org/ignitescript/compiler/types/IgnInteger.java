package org.ignitescript.compiler.types;

import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

public class IgnInteger extends IgnPrimitiveTypeImpl<Integer> {

    protected IgnInteger(Integer value) {
        super(value);
    }

    @Override
    public NativeType getJavaType() {
        return NativeType.INTEGER;
    }

    @Override
    public void setValue(String value) {
        try{
            this.value = Integer.parseInt(value);
        } catch (Exception e){
            throw new IgnInvalidArgumentException("Invalid value for Integer type: " + value);
        }
    }
}
