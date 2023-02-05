package com.wayne.datastruct.stack;

import java.util.Arrays;

public class CustomCharStack extends MyStack<Character> {
    // private boolean isOperand(char c) {
    //     if(c == '+' || c == '-' || c == '*' || c == '/') return false; 
    //     else return true;
    // }   
    // private int getPrecedence(char c) {
    //     if(c == '+' || c == '-' ) return 1; 
    //     else if(c == '*' || c == '/') return 2;
    //     return 0;
    // }
    // public String infixToPostfix(String s) {
    //     int i,j;
    //     i = j = 0;
    //     char[] resource = s.toCharArray();
    //     char[] posfix = new char[resource.length];
    //     while(i < resource.length) {
    //         if(isOperand(resource[i])) {
    //             posfix[j++] = resource[i++];
    //         } else {
    //             if(isEmpty() || getPrecedence(resource[i]) > getPrecedence(stackTop())) {
    //                 push(resource[i++]);
    //             } else {
    //                 posfix[j++] = pop();
    //             }
    //         }
    //     }
    //     while(!isEmpty()) {
    //         posfix[j++] = pop();
    //     }
    //     return new String(posfix);
    // }
    // more tricky function: Infix, Postfix
    private boolean isOperand(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')'|| c == '^') return false; 
        else return true;
    }   
    private int getPrecedence(char c, boolean isInStack) {
        switch(c) {
            case'+':
            case'-': {
                return isInStack? 2 : 1;
            }
            case'*':
            case'/': {
                return isInStack? 4 : 3;
            }
            case'^': {
                return isInStack? 5 : 6;
            }
            case'(': {
                return isInStack? 0 : 7;
            }
            case')': {
                return 0;
            }
        }
        return -1;
    }
    public String infixToPostfix(String s) {
        int i,j;
        i = j = 0;
        char[] resource = s.toCharArray();
        char[] postfix = new char[resource.length];
        while(i < resource.length) {
            if(isOperand(resource[i])) {
                postfix[j++] = resource[i++];
            } else {
                if(isEmpty() || getPrecedence(resource[i], false) > getPrecedence(stackTop(), true)) {
                    push(resource[i++]);
                } else if(getPrecedence(resource[i], false) < getPrecedence(stackTop(), true)) {
                    postfix[j++] = pop();
                } else {
                    i++;
                    pop();
                }
            }
        }
        while(!isEmpty()) {
            postfix[j++] = pop();
        }
        return new String(postfix);
    }
}
