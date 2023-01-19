package com.wayne.datastruct.linkedList;

import java.util.Scanner;

public class MyLinkedList {
    int size = 0;
    Node<Integer> head;
    Node<Integer> tail;

    public MyLinkedList(int size) {
        if (size == 0)
            return;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values");
        int inPut = sc.nextInt();
        Node<Integer> p = new Node<Integer>(inPut);
        head = p;
        for (int i = 1; i < size; i++) {
            inPut = sc.nextInt();
            p.next = new Node<Integer>(inPut);
            p = p.next;
        }
        this.size = size;
        tail = p;
        sc.close();
    }

    public void display() {
        if (isEmpty())
            return;
        Node<Integer> temp = head;
        System.out.print("Your LinkedList: ");
        while (temp != null) {
            System.out.print(String.valueOf(temp.value) + " ");
            temp = temp.next;
        }
    }

    private boolean isEmpty() {
        return size <= 0;
    }
}
