package org.ignitescript.compiler.types.algebraic;

import org.ignitescript.compiler.annotations.IgnAlgebraicType;


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

    private Vector3(){
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
    }

    @Override
    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    @Override
    public Vector3 subtract(Vector3 other) {
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    @Override
    public Vector3 multiply(Vector3 other) {
        return new Vector3(this.x * other.x, this.y * other.y, this.z * other.z);
    }

    @Override
    public Vector3 divide(Vector3 other) {
        return new Vector3(this.x / other.x, this.y / other.y, this.z / other.z);
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
}
