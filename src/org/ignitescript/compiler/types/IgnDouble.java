package org.ignitescript.compiler.types;

import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

public class IgnDouble extends IgnPrimitiveTypeImpl<Double> {

    protected IgnDouble(Double value) {
        super(value);
    }

    @Override
    public NativeType getJavaType() {
        return NativeType.DOUBLE;
    }

    @Override
    public void setValue(String value) {
        try{
            this.value = Double.parseDouble(value);
        } catch (Exception e){
            throw new IgnInvalidArgumentException("Invalid value for double: " + value);
        }
    }
}
