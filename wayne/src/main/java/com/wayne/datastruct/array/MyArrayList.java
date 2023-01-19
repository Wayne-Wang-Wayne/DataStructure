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
        System.out.print("Your List: ");
        for (int i = 0; i < size; i++) {
            System.out.print(String.valueOf(list[i]) + "  ");
        }
    }

    public void add(int val) {
        if (size >= capacity)
            recreateList();
        list[size] = val;
        size++;
    }

    public void insert(int index, int val) {
        if (index > size)
            return;
        if (size >= capacity)
            recreateList();
        int i;
        for (i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[i] = val;
        size++;
    }

    public void delete(int index) {
        if (index >= size)
            return;
        list[index] = -1;
        for (int i = index; i < size; i++) {
            if (i + 1 <= size - 1)
                list[i] = list[i + 1];
        }
        size--;
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
