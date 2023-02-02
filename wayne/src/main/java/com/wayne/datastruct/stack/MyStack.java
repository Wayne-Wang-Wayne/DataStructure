package com.wayne.datastruct.stack;

import com.wayne.datastruct.linkedList.Node;

public class MyStack {

    Node<Integer> top;

    public MyStack() {}

    public void display() {
        System.out.println("Your Stack: ");
        Node<Integer> p = top;
        while(p != null){
            System.out.println(p.value + " ");
            p = p.next;
        }
    }

    public void push(int val) {
        Node<Integer> temp = new Node<Integer>(val);
        temp.next = top;
        top = temp;
    }

    public int pop() {
        int val = -1;
        if(top != null) {
            val = top.value;
            top = top.next;
        }
        return val;
    }

    public int peek(int pos) {
        int val = -1;
        if(pos < 0) return val;
        Node<Integer> p = top;
        for(int i = 0 ; p!= null && i < pos ; i++) {
            p = p.next;
        }
        if(p != null) val = p.value;
        return val;
    }

    public int stackTop() {
        if(top != null) return top.value; else return -1;
    }

    public boolean isEmpty() {
        return top == null;
    }

}