package com.wayne.datastruct.queue;

import com.wayne.datastruct.doublyLinkedList.Node;

public class DEQueue<T> {
    Node<T> front;
    Node<T> rear;
    int size = 0;

    public enum QueuePosition {
        FRONT, REAR
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public void insert(QueuePosition position, T val) {
        Node<T> t = new Node<>(val);
        if(isEmpty()) {
            front = rear = t;
        } else {
            if(position == QueuePosition.FRONT) {
                t.next = front;
                front.prev = t;
                front = t;
            } else {
                rear.next = t;
                t.prev = rear;
                rear = t;
            }
        }
        size++;
    }

    public T delete(QueuePosition position) {
        T val = null;
        if(isEmpty()) {
            System.out.print("Queue is empty!!");
            return val;
        }
        if(size == 1) {
            val = front.value;
            front = rear = null;
        } else {
            if(position == QueuePosition.FRONT) {
                val = front.value;
                front = front.next;
                front.prev = null;
            } else {
                val = rear.value;
                rear = rear.prev;
                rear.next = null;
            }
        }
        if(size > 0)size--;
        return val;
    }

    public void display() {
        Node<T> curr = front;
        System.out.print("Your Doubly Ends Queue: ");
        while(curr != null) {
            System.out.print(curr.value.toString() + " ");
            curr = curr.next;
        }
    }
}
