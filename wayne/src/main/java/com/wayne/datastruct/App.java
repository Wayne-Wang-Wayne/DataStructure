package com.wayne.datastruct;

import com.wayne.datastruct.array.MyArrayList;
import com.wayne.datastruct.doublyLinkedList.DoublyLinkedList;
import com.wayne.datastruct.linkedList.CircularLinkedList;
import com.wayne.datastruct.linkedList.MyLinkedList;

public final class App {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 });
        list.display();
    }
}
