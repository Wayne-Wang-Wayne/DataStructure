package com.wayne.datastruct.sortUtils;

public class SortUtils {
    
    // min: O(n)
    // max: O(n^2)
    // adaptive: true
    // stable: true
    public static void bubbleSort(int[] list) {
        boolean hasSwap = false;
        for(int i = 0 ; i < list.length - 1 ; i++) {
            hasSwap = false;
            for(int j = 0 ; j < list.length-1-i ; j++) {
                if(list[j] > list[j+1]) {
                    // swap
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    hasSwap = true;
                }
            }
            // if no change made in current loop means it was sorted
            if(!hasSwap) break;
        }
    }

    public static void printList(int[] list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}
