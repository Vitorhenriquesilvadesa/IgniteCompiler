package org.ignitescript.compiler.types;

public class IgnString extends IgnPrimitiveTypeImpl<String> {

    protected IgnString(String value) {
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
