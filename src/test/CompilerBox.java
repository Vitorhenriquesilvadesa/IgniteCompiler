package test;

import org.ignitescript.compiler.lexer.expression.arithmetic.Tree;

public class CompilerBox {
    public static void main(String[] args) {
        Tree<Integer> arvere = new Tree<Integer>();
        arvere.insertRecursive(10);
        arvere.insertRecursive(20);
        arvere.insertRecursive(30);

        System.out.println(arvere.search(0));


    }
}
