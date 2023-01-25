package com.wayne.datastruct;

import com.wayne.datastruct.array.MyArrayList;
import com.wayne.datastruct.linkedList.MyLinkedList;

public final class App {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insertAtLast(10);
        list.insertAtLast(13);
        list.insertAtLast(13);
        list.insertAtLast(13);
        list.insertAtLast(18);
        list.insertAtLast(19);
        list.insertAtLast(20);
        MyLinkedList list2 = new MyLinkedList();
        list2.insertAtLast(10);
        list2.insertAtLast(13);
        list2.insertAtLast(14);
        list2.insertAtLast(14);
        list2.insertAtLast(18);
        list2.insertAtLast(19);
        list2.insertAtLast(19);
        MyLinkedList list3 = list.merge(list2);
        // System.out.println(list.delete(1));
        list3.rDisplay();
    }
}
