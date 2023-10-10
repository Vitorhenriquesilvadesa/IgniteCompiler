import org.ignitescript.compiler.input.IgnEntryPointFile;
import org.ignitescript.compiler.lexer.Lexer;
import org.ignitescript.compiler.lexer.expression.*;
import org.ignitescript.compiler.lexer.expression.arithmetic.ArithmeticExpressionAnalyzer;
import org.ignitescript.compiler.types.algebraic.Vector3;
import org.ignitescript.compiler.types.natives.IgnInteger;
import org.ignitescript.compiler.types.natives.IgnObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String expression = "true OR true AND true || false";

        Lexer.run("res/test");

    }
}