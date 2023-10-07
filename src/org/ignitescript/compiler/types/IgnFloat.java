package org.ignitescript.compiler.types;

import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

public class IgnFloat extends IgnPrimitiveTypeImpl<Float> {

    protected IgnFloat(Float value) {
        super(value);
    }

    @Override
    public NativeType getJavaType() {
        return NativeType.FLOAT;
    }

    @Override
    public void setValue(String value) {
        try{
            this.value = Float.parseFloat(value);
        } catch (Exception e){
            throw new IgnInvalidArgumentException("Invalid value for float: " + value);
        }
    }
}
