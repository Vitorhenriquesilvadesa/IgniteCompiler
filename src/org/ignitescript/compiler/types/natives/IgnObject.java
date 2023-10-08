package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;
import org.ignitescript.compiler.types.IgnHashGenerator;

@IgnNativeType
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
