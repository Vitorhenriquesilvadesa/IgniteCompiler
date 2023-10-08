package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;
import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

@IgnNativeType
public class IgnFloat extends IgnPrimitiveTypeImpl<Float> implements IgnNumber {

    public IgnFloat(Float value) {
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

    @Override
    public void add(IgnNumber other) {
        super.value = super.value + other.getValue().floatValue();
    }

    @Override
    public void subtract(IgnNumber other) {
        super.value = super.value - other.getValue().floatValue();
    }

    @Override
    public void multiply(IgnNumber other) {
        super.value = super.value * other.getValue().floatValue();
    }

    @Override
    public void divide(IgnNumber other) {
        super.value = super.value / other.getValue().floatValue();
    }

    @Override
    public int compareTo(IgnNumber o) {
        return 0;
    }
}
