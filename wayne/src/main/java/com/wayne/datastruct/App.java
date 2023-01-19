package com.wayne.datastruct;

import com.wayne.datastruct.array.MyArrayList;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(5, 3);
        System.out.println(list.search(4));
        list.display();
    }
}
