package org.ignitescript.compiler.types.natives;

public interface IgnNumber extends Comparable<IgnNumber> {

    public void add(IgnNumber other);
    public void subtract(IgnNumber other);
    public void multiply(IgnNumber other);
    public void divide(IgnNumber other);

    public Number getValue();
}
