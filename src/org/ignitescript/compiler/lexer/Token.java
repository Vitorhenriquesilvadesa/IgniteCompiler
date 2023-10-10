package org.ignitescript.compiler.lexer;

public class Token {

    private String token;
    private TokenType type;

    public Token(String token, TokenType type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public TokenType getType() {
        return type;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String toString() {
        return "<\"" + token + "\", Type: " + type + ">";
    }
}
