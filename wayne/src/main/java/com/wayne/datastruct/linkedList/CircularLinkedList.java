package com.wayne.datastruct.linkedList;

public class CircularLinkedList {
    int size = 0;
    Node<Integer> head;

    public CircularLinkedList(int[] list) {
        if (list == null)
            throw new NullPointerException();
        if (list.length < 0)
            throw new IllegalArgumentException();
        if (list.length == 0)
            return;
        size = list.length;
        head = new Node<Integer>(list[0]);
        Node<Integer> curr = head;
        for (int i = 1; i < size; i++) {
            curr.next = new Node<Integer>(list[i]);
            curr = curr.next;
        }
        curr.next = head;
    }

    public void display() {
        if (head == null)
            return;
        Node<Integer> curr = head;
        System.out.println("Your circular linkedList: ");
        do {
            System.out.print(curr.value + " ");
            curr = curr.next;
        } while (curr != head);
    }

    public void rDisplay() {
        System.out.println("Your circular linkedList: ");
        rDisplayRider(head);
    }

    boolean rDisplayFlag = false;

    private void rDisplayRider(Node<Integer> curr) {
        if (curr == head && rDisplayFlag)
            return;
        rDisplayFlag = true;
        System.out.print(curr.value + " ");
        rDisplayRider(curr.next);
    }
}
