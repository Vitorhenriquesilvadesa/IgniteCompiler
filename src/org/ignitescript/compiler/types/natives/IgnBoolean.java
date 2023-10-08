package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;
import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;


@IgnNativeType
public class IgnBoolean extends IgnPrimitiveTypeImpl<Boolean> {

    public IgnBoolean(boolean value) {
        super(value);
    }

    @Override
    public NativeType getJavaType() {
        return NativeType.BOOLEAN;
    }

    @Override
    public void setValue(String value) {
        if ((value.equals("true") || value.equals("false"))) {
            this.value = Boolean.parseBoolean(value);
        } else {
            throw new IgnInvalidArgumentException("Invalid boolean value: " + value);
        }
    }
}
