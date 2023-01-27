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

    public void insert(int index, int val) {
        if (index < 0 || index > size)
            return;
        Node<Integer> t = new Node<Integer>(val);
        Node<Integer> curr = head;
        if (index == 0 || index == size) {
            if (head == null) {
                head = t;
                head.next = head;
            } else {
                while (curr.next != head) {
                    curr = curr.next;
                }
                t.next = head;
                curr.next = t;
                if (index == 0)
                    head = t;
            }
        } else {
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            t.next = curr.next;
            curr.next = t;
        }
        size++;
    }

    public int delete(int index) {
        int val = -1;
        if (index < 0 || index >= size)
            return val;
        Node<Integer> curr = head;
        if (index == 0) {
            while (curr.next != head)
                curr = curr.next;
            if (curr == head) {
                head = null;
                val = curr.value;
            } else {
                val = head.value;
                curr.next = head.next;
                head = curr.next;
            }
        } else {
            curr = head;
            for (int i = 0; i < index - 1; i++)
                curr = curr.next;
            val = curr.next.value;
            curr.next = curr.next.next;
        }
        size--;
        return val;
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
