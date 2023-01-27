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

    private boolean isEmpty() {
        return size <= 0;
    }

    public int getSize() {
        return size;
    }
}
