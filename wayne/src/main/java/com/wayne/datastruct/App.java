package com.wayne.datastruct;

import com.wayne.datastruct.array.MyArrayList;
import com.wayne.datastruct.linkedList.MyLinkedList;

public final class App {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insertAtLast(10);
        list.insertAtLast(13);
        list.insertAtLast(19);
        System.out.println("is sorted? " + list.isSorted());
        System.out.println(list.delete(1));
        list.rDisplay();
    }
}
