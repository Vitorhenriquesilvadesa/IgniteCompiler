package org.ignitescript.compiler.lexer;

public enum TokenType {

    SYSTEM,
    KEYWORD,
    // Keywords
    IF,
    ELSE,
    WHILE,
    FOR,
    RETURN,
    BREAK,
    CONTINUE,
    TRUE,
    FALSE,
    NULL,
    THIS,
    NEW,
    CLASS,
    PUBLIC,
    PRIVATE,
    PROTECTED,
    STATIC,
    FINAL,
    ABSTRACT,
    EXTENDS,
    IMPLEMENTS,
    INTERFACE,
    PACKAGE,
    IMPORT,
    // Operators
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    MODULO,
    ASSIGN,
    PLUS_ASSIGN,
    MINUS_ASSIGN,
    MULTIPLY_ASSIGN,
    DIVIDE_ASSIGN,
    MODULO_ASSIGN,
    EQUALS,
    NOT_EQUALS,
    GREATER_THAN,
    LESS_THAN,
    GREATER_THAN_OR_EQUAL,
    LESS_THAN_OR_EQUAL,
    AND,
    OR,
    NOT,
    // Symbols
    LEFT_PARENTHESIS,
    RIGHT_PARENTHESIS,
    LEFT_BRACE,
    RIGHT_BRACE,
    LEFT_BRACKET,
    RIGHT_BRACKET,
    COMMA,
    DOT,
    SEMICOLON,
    COLON,
    // Literals
    IDENTIFIER,
    INTEGER_LITERAL,
    FLOAT_LITERAL,
    STRING_LITERAL,
    // End of file
    EOF
}
