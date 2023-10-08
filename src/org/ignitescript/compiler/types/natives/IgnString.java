package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;

@IgnNativeType
public class IgnString extends IgnPrimitiveTypeImpl<String> {

    public IgnString(String value) {
        super(value);
    }

    @Override
    public NativeType getJavaType() {
        return NativeType.STRING;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
