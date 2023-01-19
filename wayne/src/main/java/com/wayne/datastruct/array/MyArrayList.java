package com.wayne.datastruct.array;

import java.util.Arrays;
import java.util.Scanner;

public class MyArrayList {

    int capacity;
    int size;
    int[] list;

    public MyArrayList(int size, int capacity) {
        if (capacity < size)
            capacity = size;
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
        if (isEmpty())
            return;
        System.out.print("Your List: ");
        for (int i = 0; i < size; i++) {
            System.out.print(String.valueOf(list[i]) + "  ");
        }
    }

    public void add(int val) {
        if (size >= capacity)
            resizeList();
        list[size] = val;
        size++;
    }

    public void insert(int index, int val) {
        if (index > size)
            return;
        if (size >= capacity)
            resizeList();
        int i;
        for (i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[i] = val;
        size++;
    }

    public int get(int index) {
        if (isEmpty())
            return -1;
        return list[index];
    }

    public void set(int index, int val) {
        if (isEmpty())
            return;
        list[index] = val;
    }

    public int max() {
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (list[i] > temp)
                temp = list[i];
        }
        return temp;
    }

    public int min() {
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (list[i] < temp)
                temp = list[i];
        }
        return temp;
    }

    public void reverse() {
        if (isEmpty())
            return;
        int l, h;
        l = 0;
        h = size - 1;
        while (l < h) {
            int temp = list[h];
            list[h] = list[l];
            list[l] = temp;
        }
    }

    public void leftRotate() {
        if (isEmpty())
            return;
        int i;
        int temp = list[0];
        for (i = 0; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[i] = temp;
    }

    public void delete(int index) {
        if (isEmpty())
            return;
        list[index] = -1;
        for (int i = index; i < size; i++) {
            if (i + 1 <= size - 1)
                list[i] = list[i + 1];
        }
        size--;
    }

    public int search(int val) {
        if (isEmpty())
            return -1;
        if (isSorted())
            return binarySearch(val);
        for (int i = 0; i < size; i++) {
            if (list[i] == val)
                return i;
        }
        return -1;
    }

    // only can be used when list is sorted
    public int binarySearch(int val) {
        int l, h, m;
        l = 0;
        h = size - 1;
        while (l <= h) {
            m = (l + h) / 2;
            if (list[m] > val) {
                l = m + 1;
            } else if (list[m] < val) {
                h = m - 1;
            } else {
                return list[m];
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (list == null)
            return true;
        return size <= 0;
    }

    // use simple hashing
    public void printPairOfSum(int sum) {
        if (size < 2)
            return;
        // calculate table size
        int minVal, maxVal;
        minVal = Integer.MAX_VALUE;
        maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (list[i] < minVal) {
                minVal = list[i];
                continue;
            }
            if (list[i] > maxVal) {
                maxVal = list[i];
            }
        }
        // create table
        int[] table = new int[maxVal - minVal + 1];
        Arrays.fill(table, 0);
        for (int i = 0; i < size; i++) {
            // hash fuction: f(x) = x - minVal
            table[list[i] - minVal]++;
            if (table[sum - list[i] - minVal] > 0)
                // pair found
                System.out.println("Coresponding pair: " + String.valueOf(list[i]) + ", "
                        + String.valueOf(sum - list[i]));

        }

    }

    private boolean isSorted() {
        if (isEmpty())
            return false;
        int i, temp;
        temp = Integer.MIN_VALUE;
        for (i = 0; i < size; i++) {
            if (temp > list[i])
                return false;
            temp = list[i];
        }
        return true;
    }

    private void resizeList() {
        capacity = capacity * 2;
        int[] tempList = new int[capacity];
        for (int i = 0; i < size; i++) {
            tempList[i] = list[i];
        }
        list = tempList;
    }
}
