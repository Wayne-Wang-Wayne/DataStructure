package com.wayne.datastruct.stack;

import java.util.Arrays;

public class CustomCharStack extends MyStack<Character> {
    // special function: Infix, Postfix
    private boolean isOperand(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '/') return false; 
        else return true;
    }   
    private int getPrecedence(char c) {
        if(c == '+' || c == '-' ) return 1; 
        else if(c == '*' || c == '/') return 2;
        return 0;
    }
    public String infixToPostfix(String s) {
        int i,j;
        i = j = 0;
        char[] resource = s.toCharArray();
        char[] posfix = new char[resource.length];
        while(i < resource.length) {
            if(isOperand(resource[i])) {
                posfix[j++] = resource[i++];
            } else {
                if(isEmpty() || getPrecedence(resource[i]) > getPrecedence(stackTop())) {
                    push(resource[i++]);
                } else {
                    posfix[j++] = pop();
                }
            }
        }
        while(!isEmpty()) {
            posfix[j++] = pop();
        }
        return new String(posfix);
    }
}
