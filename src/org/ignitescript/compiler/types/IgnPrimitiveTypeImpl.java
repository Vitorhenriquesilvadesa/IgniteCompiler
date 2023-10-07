package org.ignitescript.compiler.types;

public abstract class IgnPrimitiveTypeImpl<T> extends IgnObject implements IgnPrimitiveType<T>{
    protected T value;

    protected IgnPrimitiveTypeImpl(T value) {
        this.value = value;
    }

    @Override
    public T getValue() { return this.value; }
}
