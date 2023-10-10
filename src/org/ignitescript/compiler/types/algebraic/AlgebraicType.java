package org.ignitescript.compiler.types.algebraic;

/**
 * This interface defines common algebraic operations for types.
 *
 * @param <T> The type implementing this interface.
 */
public interface AlgebraicType<T> {

    /**
     * Adds another value of the same type to this value.
     *
     * @param other The value to add.
     * @return The result of the addition operation.
     */
    T add(T other);

    /**
     * Subtracts another value of the same type from this value.
     *
     * @param other The value to subtract.
     * @return The result of the subtraction operation.
     */
    T subtract(T other);

    /**
     * Multiplies this value by another value of the same type.
     *
     * @param other The value to multiply by.
     * @return The result of the multiplication operation.
     */
    T multiply(T other);

    /**
     * Divides this value by another value of the same type.
     *
     * @param other The value to divide by.
     * @return The result of the division operation.
     */
    T divide(T other);

    /**
     * Calculates the length or magnitude of this value.
     *
     * @return The length or magnitude of this value.
     */
    float length();

    /**
     * Calculates the dot product between this value and another value of the same type.
     *
     * @param other The other value to calculate the dot product with.
     * @return The result of the dot product operation.
     */
    float dot(T other);
}
