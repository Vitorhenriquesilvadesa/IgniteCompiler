package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;
import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

@IgnNativeType
public class IgnShort extends IgnPrimitiveTypeImpl<Short> implements IgnNumber {
    public IgnShort(Short value) {
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

    @Override
    public void add(IgnNumber other) {
        super.value = (short) (super.value + other.getValue().shortValue());
    }

    @Override
    public void subtract(IgnNumber other) {
        super.value = (short) (super.value - other.getValue().shortValue());
    }

    @Override
    public void multiply(IgnNumber other) {
        super.value = (short) (super.value * other.getValue().shortValue());
    }

    @Override
    public void divide(IgnNumber other) {
        super.value = (short) (super.value / other.getValue().shortValue());
    }

    @Override
    public int compareTo(IgnNumber o) {
        return 0;
    }
}
