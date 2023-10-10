package org.ignitescript.compiler.types.algebraic;

import org.ignitescript.compiler.annotations.IgnAlgebraicType;

import java.lang.Math;
import java.util.Objects;

@IgnAlgebraicType
public class Vector3 extends AlgebraicTypeImpl<Vector3> {

    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    private Vector3() {
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
    }

    /**
     * Handling with float point precision, in some cases the method's can return -0 and that`s cover it
     **/
    public static Vector3 verifyZero(Vector3 vector) {
        if (Math.abs(vector.x) < 1e-6) {
            vector.x = 0;
        }
        if (Math.abs(vector.y) < 1e-6) {
            vector.y = 0;
        }
        if (Math.abs(vector.z) < 1e-6) {
            vector.z = 0;
        }
        return vector;
    }

    public static Vector3 cross(Vector3 vector, Vector3 other) {
        return new Vector3(vector.y * other.z - vector.z * other.y, vector.z * other.x - vector.x * other.z, vector.x * other.y - vector.y * other.x);
    }

    public static Vector3 projection(Vector3 vector, Vector3 other) {
        float scalarProjection = vector.dot(other) / other.dot(other);
        return multiply(other, scalarProjection);
    }

    public static Vector3 rejection(Vector3 vector, Vector3 other) {
        float scalarRejection = vector.dot(other) / other.dot(other);
        return multiply(vector.subtract(other), scalarRejection);
    }

    public static float magnitude(Vector3 other) {
        return ((float) Math.sqrt(other.x * other.x + other.y * other.y + other.z * other.z));
    }

    public static Vector3 normalize(Vector3 other) {
        return divide(other, magnitude(other));
    }

    public static Vector3 negated(Vector3 other) {
        return multiply(other, -1);
    }

    public static Vector3 span(Vector3 vector, Vector3 other, float scalar1, float scalar2) {
        return add(multiply(vector, scalar1), multiply(other, scalar2));
    }

    public static Vector3 multiply(Vector3 vector, float scalar) {
        return new Vector3(vector.x * scalar, vector.y * scalar, vector.z * scalar);
    }

    public static Vector3 divide(Vector3 other, float scalar) {
        return new Vector3(other.x / scalar, other.y / scalar, other.z / scalar);
    }

    public static Vector3 add(Vector3 vector, Vector3 other) {
        return new Vector3(vector.x + other.x, vector.y + other.y, +vector.z + other.z);
    }


    @Override
    public Vector3 add(Vector3 other) {
        return verifyZero(new Vector3(this.x + other.x, this.y + other.y, this.z + other.z));
    }

    @Override
    public Vector3 subtract(Vector3 other) {
        return verifyZero(new Vector3(this.x - other.x, this.y - other.y, this.z - other.z));
    }

    @Override
    public Vector3 multiply(Vector3 other) {
        return verifyZero(new Vector3(this.x * other.x, this.y * other.y, this.z * other.z));
    }

    @Override
    public Vector3 divide(Vector3 other) {
        return verifyZero(new Vector3(this.x / other.x, this.y / other.y, this.z / other.z));
    }

    @Override
    public float length() {
        return (float) (Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z));
    }

    @Override
    public float dot(Vector3 other) {
        return (this.x * other.x + this.y * other.y + this.z * other.z);
    }

    public static Vector3 zero() {
        return new Vector3();
    }

    public static Vector3 forward() {
        return new Vector3(0, 0, 1);
    }

    public static Vector3 back() {
        return new Vector3(0, 0, -1);
    }

    public static Vector3 left() {
        return new Vector3(-1, 0, 0);
    }

    public static Vector3 right() {
        return new Vector3(1, 0, 0);
    }

    public static Vector3 up() {
        return new Vector3(0, 1, 0);
    }

    public static Vector3 down() {
        return new Vector3(0, -1, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;
        Vector3 vector = (Vector3) o;
        return Float.compare(vector.x, x) == 0 && Float.compare(vector.y, y) == 0 && Float.compare(vector.z, z) == 0;

    }
}
