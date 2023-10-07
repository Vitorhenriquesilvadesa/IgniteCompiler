package org.ignitescript.compiler.types;

public class IgnObject {

    private String hash;

    public IgnObject() {
        hash = IgnHashGenerator.next(this);
    }

    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return hash;
    }
}
