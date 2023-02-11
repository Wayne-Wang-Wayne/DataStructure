package com.wayne.datastruct.queue;

import com.wayne.datastruct.linkedList.Node;

public class MyQueue<T> {
    int size = 0;
    Node<T> front;
    Node<T> rear;

    public boolean isEmpty() {
        return size <= 0;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        Node<T> curr = front;
        // System.out.print("Your queue: ");
        while(curr != null) {
            System.out.print(curr.value.toString() + " ");
            curr = curr.next;
        }
    }

    public void enqueue(T val) {
        Node<T> t = new Node<>(val);
        if(front == null) {
            front = t;
            rear = t;
        } else {
            rear.next = t;
            rear = rear.next;
        }
        size++;
    }

    public T dequeue() {
        T val = null;
        if(front == null) {
            System.out.print("Queue is Empty!!");
            return val;
        } 
        val = front.value;
        if(front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        if(size > 0)size--;
        return val;
    }
}
