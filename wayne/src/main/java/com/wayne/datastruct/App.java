package com.wayne.datastruct;

import com.wayne.datastruct.array.MyArrayList;
import com.wayne.datastruct.doublyLinkedList.CircularDoublyLinkedList;
import com.wayne.datastruct.doublyLinkedList.DoublyLinkedList;
import com.wayne.datastruct.linkedList.CircularLinkedList;
import com.wayne.datastruct.linkedList.MyLinkedList;

public final class App {

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 });
        list.insert(3, 10);
        list.display();
    }
}
