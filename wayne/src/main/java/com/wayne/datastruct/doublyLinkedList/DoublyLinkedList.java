package com.wayne.datastruct.doublyLinkedList;

public class DoublyLinkedList {
    Node<Integer> head;
    int size = 0;

    public DoublyLinkedList(int[] list) {
        if (list == null)
            return;
        if (list.length <= 0)
            return;
        Node<Integer> curr;
        curr = new Node<Integer>(list[0]);
        head = curr;
        for (int i = 1; i < list.length; i++) {
            Node<Integer> temp = new Node<Integer>(list[i]);
            curr.next = temp;
            temp.prev = curr;
            curr = curr.next;
        }
        this.size = list.length;
    }

    public void display() {
        if (isEmpty())
            return;
        Node<Integer> temp = head;
        System.out.print("Your DoublyLinkedList: ");
        while (temp != null) {
            System.out.print(String.valueOf(temp.value) + " ");
            temp = temp.next;
        }
    }

    public void insert(int index, int val) {
        if (index < 0 || index > size)
            return;
        Node<Integer> temp = new Node<Integer>(val);
        Node<Integer> curr = head;
        if (index == 0) {
            if (head == null) {
                head = temp;
            } else {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
        } else {
            for (int i = 0; i < index - 1; i++)
                curr = curr.next;
            if (curr.next != null)
                curr.next.prev = temp;
            temp.next = curr.next;
            temp.prev = curr;
            curr.next = temp;
        }
        size++;
    }

    public int delete(int index) {
        int val = -1;
        Node<Integer> curr = head;
        if (index < 0 || index >= size)
            return val;
        if (index == 0) {
            val = head.value;
            head = head.next;
            if (head != null)
                head.prev = null;
        } else {
            for (int i = 0; i < index; i++)
                curr = curr.next;
            val = curr.value;
            curr.prev.next = curr.next;
            if (curr.next != null)
                curr.next.prev = curr.prev;
        }
        size--;
        return val;

    }

    private boolean isEmpty() {
        return size <= 0;
    }

    public int getSize() {
        return size;
    }
}
