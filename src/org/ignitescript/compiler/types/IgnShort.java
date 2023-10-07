package org.ignitescript.compiler.types;

import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

public class IgnShort extends IgnPrimitiveTypeImpl<Short> {
    protected IgnShort(Short value) {
        super(value);
    }

    @Override
    public NativeType getJavaType() {
        return NativeType.SHORT;
    }

    @Override
    public void setValue(String value) {
        try{
            this.value = Short.parseShort(value);
        } catch (Exception e){
            throw new IgnInvalidArgumentException("Invalid value for short: " + value);
        }
    }
}
