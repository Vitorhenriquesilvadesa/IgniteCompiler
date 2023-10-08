package org.ignitescript.compiler.types.algebraic;

public interface AlgebraicType<T> {

    T add(T other);
    T subtract(T other);
    T multiply(T other);
    T divide(T other);
    float length();
    float dot(T other);
}
