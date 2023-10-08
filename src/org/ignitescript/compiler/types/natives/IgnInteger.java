package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;
import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

@IgnNativeType
public class IgnInteger extends IgnPrimitiveTypeImpl<Integer> implements IgnNumber {

    public IgnInteger(Integer value) {
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

    @Override
    public void add(IgnNumber other) {
        super.value = super.value + other.getValue().intValue();
    }

    @Override
    public void subtract(IgnNumber other) {
        super.value = super.value - other.getValue().intValue();
    }

    @Override
    public void multiply(IgnNumber other) {
        super.value = super.value * other.getValue().intValue();
    }

    @Override
    public void divide(IgnNumber other) {
        super.value = super.value / other.getValue().intValue();
    }

    @Override
    public int compareTo(IgnNumber o) {
        return 0;
    }
}
