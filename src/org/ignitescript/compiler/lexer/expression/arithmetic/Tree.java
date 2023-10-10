package org.ignitescript.compiler.lexer.expression.arithmetic;


@SuppressWarnings("unchecked")
public class Tree<T extends Comparable<T>> {
    Node<T> root;
    public void insertRecursive(T value){
        root = insertRecursive(root, value);
    }
    private Node<T> insertRecursive(Node<T> node, T value){
        if(node == null){
            return new Node<T>(value);
        }
        if(value.compareTo(node.value) < 0){
            node.left = insertRecursive(node.left, value);
        }else if(value.compareTo(node.value) > 0){
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    public boolean search(T value){
        return searchRecursive(root, value);
    }
    public boolean searchRecursive(Node<T> node, T value){
        if(node == null){
            return false;
        }
        if(value == node.value){
            return true;
        }else if(value.compareTo(node.value) < 0){
            return searchRecursive(node.left, value);
        }else if(value.compareTo(node.value) > 0){
            return searchRecursive(node.right, value);
        }

        return false;
    }
}
