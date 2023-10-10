package org.ignitescript.compiler.types.natives;

import org.ignitescript.compiler.annotations.IgnNativeType;
import org.ignitescript.compiler.types.IgnHashGenerator;

/**
 * Base class for native IgniteScript types.
 *
 * <p>This class is annotated with {@link IgnNativeType} to indicate that it is a native type in the IgniteScript language.</p>
 */
@IgnNativeType
public class IgnObject {

    /**
     * A unique hash code generated for each instance of this class.
     */
    private final String hash;

    /**
     * Constructs a new instance of IgnObject and generates a unique hash code for it.
     */
    public IgnObject() {
        hash = IgnHashGenerator.next(this);
    }

    /**
     * Gets the unique hash code associated with this instance.
     *
     * @return The unique hash code.
     */

    public String getHash() {
        return hash;
    }

    /**
     * Returns a string representation of this object, which is its unique hash code.
     *
     * @return The string representation of this object.
     */
    @Override
    public String toString() {
        return hash;
    }

    public NativeType getJavaType(){
        return NativeType.OBJECT;
    }
}
