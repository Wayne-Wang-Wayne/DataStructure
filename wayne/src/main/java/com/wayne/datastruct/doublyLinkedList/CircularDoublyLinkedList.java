package com.wayne.datastruct.doublyLinkedList;

public class CircularDoublyLinkedList {
  int size = 0;
  Node<Integer> head;

  public CircularDoublyLinkedList(int[] list) {
    if (list == null)
      return;
    if (list.length <= 0)
      return;
    size = list.length;
    head = new Node<Integer>(list[0]);
    Node<Integer> curr = head;
    Node<Integer> temp;
    for (int i = 1; i < size; i++) {
      temp = new Node<Integer>(list[i]);
      curr.next = temp;
      temp.prev = curr;
      temp.next = head;
      head.prev = temp;
      curr = temp;
    }
  }

  public void display() {
    if (head == null)
      return;
    Node<Integer> curr = head;
    System.out.println("Yout Circular Doubly LinkedList: ");
    do {
      System.out.print(curr.value + " ");
      curr = curr.next;
    } while (curr != head);
  }

  public void insert(int index, int val) {
    if (index < 0 || index > size)
      return;
    Node<Integer> temp = new Node<Integer>(val);
    if (head == null) {
      head = temp;
      size++;
      return;
    }
    Node<Integer> curr = head.prev;
    for (int i = 0; i < index; i++)
      curr = curr.next;
    temp.prev = curr;
    temp.next = curr.next;
    curr.next.prev = temp;
    curr.next = temp;
    if (index == 0)
      head = temp;
    size++;
  }

  public int getSize() {
    return size;
  }

  public int delete(int index) {
    int val = -1;
    if (index < 0 || index >= size)
      return val;
    if (size == 1) {
      size--;
      val = head.value;
      head = null;
      return val;
    }
    Node<Integer> curr = head;
    for (int i = 0; i < index; i++)
      curr = curr.next;
    curr.prev.next = curr.next;
    curr.next.prev = curr.prev;
    val = curr.value;
    if (index == 0)
      head = curr.next;
    size--;
    return val;
  }
}
