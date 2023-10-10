package org.ignitescript.compiler.lexer;

import org.ignitescript.compiler.input.IgnEntryPointFile;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Lexer {

    private static boolean initialized = false;
    private static Map<String, TokenType> symbolTable;

    public static void run(String filePath) throws IOException {
        String expression = IgnEntryPointFile.getEntryPointFile(filePath);
        lex(expression);
    }

    private static List<Token> lex(String expression) {

        if (!initialized) {
            initSymbolTable();
            initialized = true;
        }

        int i = 0;
        String matchedToken = " ";
        StringBuilder currentToken = new StringBuilder();
        List<Token> tokens = new ArrayList<>();

        char currentChar = ' ';

        while (i < expression.length()) {

        }
    }

    private static boolean isDelimiter(char c) {
        return (c == '.' || c == '(' || c == ')');
    }

    private static void initSymbolTable() {
        symbolTable = new HashMap<>();

        symbolTable.put("system", TokenType.SYSTEM);
        symbolTable.put("println", TokenType.KEYWORD);
        symbolTable.put("print", TokenType.KEYWORD);
        symbolTable.put(".", TokenType.DOT);
        symbolTable.put("(", TokenType.LEFT_PARENTHESIS);
        symbolTable.put(")", TokenType.RIGHT_PARENTHESIS);
        symbolTable.put(";", TokenType.SEMICOLON);
    }
}