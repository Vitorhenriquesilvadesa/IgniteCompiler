package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;
import org.ignitescript.compiler.exceptions.IgnInvalidArgumentException;

@IgnNativeType
public class IgnChar extends IgnPrimitiveTypeImpl<Character>{

    public IgnChar(Character value) {
        super(value);
    }

    @Override
    public NativeType getJavaType() {
        return null;
    }

    @Override
    public void setValue(String value) {
        if (value.length() == 1) {
            this.value = value.charAt(0);
        } else {
            throw new IgnInvalidArgumentException("Invalid char value: " + value);
        }
    }

    public IgnInteger toInteger(){
        return new IgnInteger((int)super.getValue());
    }
}
