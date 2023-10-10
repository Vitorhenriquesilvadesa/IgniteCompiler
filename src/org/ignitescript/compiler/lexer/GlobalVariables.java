package org.ignitescript.compiler.lexer;

import org.ignitescript.compiler.types.natives.IgnObject;

import java.util.HashMap;
import java.util.Map;

public final class GlobalVariables {

    public static Map<String, IgnObject> variables = new HashMap<>();

    public static void declareVariable(String type, String name, IgnObject value) {

        if (variables.containsKey(name)) {
            throw new IllegalArgumentException("Variable " + name + " already declared");
        }

        variables.put(name, value);
    }
}
