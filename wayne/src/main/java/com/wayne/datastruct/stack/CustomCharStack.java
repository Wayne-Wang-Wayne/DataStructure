package com.wayne.datastruct.stack;

import java.util.ArrayList;
import java.util.List;

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
    private boolean isOperand(String c) {
        if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("(" ) || c.equals(")") || c.equals("^")) return false; 
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
    private List<String> infixToPostfix(String s) {
        int i;
        i = 0;
        char[] resource = s.toCharArray();
        List<String> postfix = new ArrayList<String>();
        String curString = "";
        while(i < resource.length) {
            if(isOperand(resource[i])) {
                curString = "";
                while( i < resource.length && isOperand(resource[i])) {
                    curString += resource[i];
                    i++;
                }
                postfix.add(curString);
            } else {
                if(isEmpty() || getPrecedence(resource[i], false) > getPrecedence(stackTop(), true)) {
                    push(resource[i++]);
                } else if(getPrecedence(resource[i], false) < getPrecedence(stackTop(), true)) {
                    postfix.add(pop().toString());
                } else {
                    i++;
                    pop();
                }
            }
        }
        while(!isEmpty()) {
            postfix.add(pop().toString());
        }
        return postfix;
    }

    public int calculate(String s) {
        List<String> postfix = infixToPostfix(s);
        MyStack<Integer> stack = new MyStack<>();
        for(int i = 0 ; i < postfix.size() ; i++) {
            if(isOperand(postfix.get(i))) {
                stack.push(Integer.valueOf(postfix.get(i)));
            } else {
                int first = stack.pop();
                int second = stack.pop();
                switch(postfix.get(i)) {
                    case "+":{
                        stack.push(second + first);
                        break;
                    }
                    case "-":{
                        stack.push(second - first);
                        break;
                    }
                    case "*":{
                        stack.push(second * first);
                        break;
                    }
                    case "/":{
                        stack.push(second / first);
                        break;
                    }
                    case "^":{
                        stack.push((int) Math.round(Math.pow(second, first)));
                        break;
                    }
                }
            }
        }
        return stack.pop();
    }
}
