package org.ignitescript.compiler.types.natives;

/**
 * This interface is implemented by all primitive types present
 * in IgniteScript language. In native Java, all type are
 * transformed to their corresponding Java types in execution time.
 */
public interface IgnPrimitiveType<T> {

    public abstract T getValue();
    public abstract NativeType getJavaType();
    public abstract void setValue(String value);
}
