package org.ignitescript.compiler.types.natives;

public class IgnVoid extends IgnObject {

    private boolean isNull;

    public IgnVoid() {
        isNull = false;
    }

    public void setNull() {
        isNull = true;
    }

    public boolean isNull() {
        return isNull;
    }

    @Override
    public NativeType getJavaType(){
        return isNull ? NativeType.NULL : NativeType.VOID;
    }
}
