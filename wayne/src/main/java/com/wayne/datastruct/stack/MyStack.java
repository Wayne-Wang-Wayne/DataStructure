package com.wayne.datastruct.stack;

import com.wayne.datastruct.linkedList.Node;

public class MyStack<T> {

    Node<T> top;

    public MyStack() {}

    public void display() {
        System.out.println("Your Stack: ");
        Node<T> p = top;
        while(p != null){
            System.out.println(p.value + " ");
            p = p.next;
        }
    }

    public void push(T val) {
        Node<T> temp = new Node<T>(val);
        temp.next = top;
        top = temp;
    }

    public T pop() {
        T val = null;
        if(top != null) {
            val = top.value;
            top = top.next;
        }
        return val;
    }

    public T peek(int pos) {
        T val = null;
        if(pos < 0) return val;
        Node<T> p = top;
        for(int i = 0 ; p!= null && i < pos ; i++) {
            p = p.next;
        }
        if(p != null) val = p.value;
        return val;
    }

    public T stackTop() {
        if(top != null) return top.value; else return null;
    }

    public boolean isEmpty() {
        return top == null;
    }

}