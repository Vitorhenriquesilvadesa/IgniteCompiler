package org.ignitescript.compiler.lexer.expression.arithmetic;


public class Node<T>{
    char operator;
    T value;
    Node left, right;

    public Node(char operator){
        this.operator = operator;
        this.left = null;
        this.right = null;
    }

    public Node(T value){
        this.operator = 0;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
