package com.wayne.datastruct.array;

import java.util.Scanner;

public class MyArrayList {

    int capacity;
    int size;
    int[] list;

    public MyArrayList(int size, int capacity) {
        Scanner sc = new Scanner(System.in);
        this.capacity = capacity;
        list = new int[capacity];
        System.out.println("Enter value");
        for (int i = 0; i < size; i++) {
            int inPut = sc.nextInt();
            add(inPut);
        }
        sc.close();
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(String.valueOf(list[i]));
        }
    }

    public void add(int val) {
        if (size >= capacity)
            recreateList();
        list[size] = val;
        size++;
    }

    private void recreateList() {
        capacity = capacity * 2;
        int[] tempList = new int[capacity];
        for (int i = 0; i < size; i++) {
            tempList[i] = list[i];
        }
        list = tempList;
    }
}
