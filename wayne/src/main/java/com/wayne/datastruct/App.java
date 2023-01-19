package com.wayne.datastruct;

import com.wayne.datastruct.array.MyArrayList;
import com.wayne.datastruct.linkedList.MyLinkedList;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(4);
        list.display();
    }
}
