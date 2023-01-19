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

    public void rDisplay() {
        System.out.print("Your LinkedList: ");
        rDisplayHelper(head);
    }

    public int sum() {
        int sum = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            sum += temp.value;
            temp = temp.next;
        }
        return sum;
    }

    public int rSum() {
        return rSumHelper(head);
    }

    private boolean isEmpty() {
        return size <= 0;
    }

    private void rDisplayHelper(Node<Integer> node) {
        if (node == null)
            return;
        System.out.print(String.valueOf(node.value) + " ");
        rDisplayHelper(node.next);
    }

    public int rSumHelper(Node<Integer> node) {
        if (node == null)
            return 0;
        return rSumHelper(node.next) + node.value;
    }
}
