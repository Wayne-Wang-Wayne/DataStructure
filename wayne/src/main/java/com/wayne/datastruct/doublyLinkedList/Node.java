package com.wayne.datastruct.doublyLinkedList;

public class Node<T> {
    T value;
    Node<T> prev;
    Node<T> next;

    Node(T value) {
        this.value = value;
    }
}
