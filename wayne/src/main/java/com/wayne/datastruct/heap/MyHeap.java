package com.wayne.datastruct.heap;

public class MyHeap {
    // 1 onward to size
    int[] list;
    int size = 0;
    public MyHeap() {
        this.list = new int[100];
    }

    public void insert(int val) {
        if(size <= 0) {
            list[1] = val;
            size = 1;
            return;
        }
        int n = size + 1;
        while(n > 1 && val > list[n/2]) {
            list[n] = list[n/2];
            n = n/2;
        }
        list[n] = val;
        size++;
    }

    public int delete() {
        if(size <= 0) return Integer.MIN_VALUE;
        int rootVal = list[1];
        list[1] = list[size];
        int n = 1;
        int j = n * 2;
        while(n <= size - 1) {
            j = n * 2;
            if(j > size - 1) break;
            if(j+1 <= size - 1 && list[j] < list[j+1]) {
                j = j+1;
            }
            if(list[j] > list[n]) {
                int temp = list[n];
                list[n] = list[j];
                list[j] = temp;
                n = n*2;
            } else break;
        }
        size--;
        return rootVal;  
    }

    public void print() {
        for(int i = 1 ; i <= size ; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public int[] heapSortTheRest() {
        int[] sortedArray = new int[size];
        while(size > 0) {
            sortedArray[size - 1] = delete();
        }
        return sortedArray;
    }
}
