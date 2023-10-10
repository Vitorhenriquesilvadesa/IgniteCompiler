package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;
import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

@IgnNativeType
public class IgnByte extends IgnPrimitiveTypeImpl<Byte> implements IgnNumber {

    protected IgnByte(Byte value) {
        super(value);
    }

    @Override
    public void add(IgnNumber other) {
        super.value = (byte) (super.value + other.getValue().byteValue());
    }

    @Override
    public void subtract(IgnNumber other) {
        super.value = (byte) (super.value - other.getValue().byteValue());
    }

    @Override
    public void multiply(IgnNumber other) {
        super.value = (byte) (super.value * other.getValue().byteValue());
    }

    @Override
    public void divide(IgnNumber other) {
        super.value = (byte) (super.value / other.getValue().byteValue());
    }

    @Override
    public void setValue(String value) {
        try {
            this.value = Byte.parseByte(value);
        } catch (Exception e) {
            throw new IgnInvalidArgumentException("Invalid value for Byte type: " + value);
        }
    }

    @Override
    public int compareTo(IgnNumber o) {
        return 0;
    }
}
