package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;
import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

@IgnNativeType
public class IgnDouble extends IgnPrimitiveTypeImpl<Double> implements IgnNumber {

    public IgnDouble(Double value) {
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


    @Override
    public void add(IgnNumber other) {
        super.value = super.value + other.getValue().doubleValue();
    }

    @Override
    public void subtract(IgnNumber other) {
        super.value = super.value - other.getValue().doubleValue();
    }

    @Override
    public void multiply(IgnNumber other) {
        super.value = super.value * other.getValue().doubleValue() ;
    }

    @Override
    public void divide(IgnNumber other) {
        super.value = super.value / other.getValue().doubleValue();
    }

    @Override
    public int compareTo(IgnNumber o) {
        return 0;
    }
}
