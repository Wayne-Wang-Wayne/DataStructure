package com.wayne.datastruct.sortUtils;

public class SortUtils {
    
    // min: O(n)
    // max: O(n^2)
    // adaptive: true
    // stable: true
    // k pass is useful: true
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

    // min: O(n)
    // max: O(n^2)
    // adaptive: true
    // stable: true
    // k pass is useful: false
    public static void insertionSort(int[] list) {
        for(int i = 1 ; i < list.length ; i++) {
            int val = list[i];
            int j = i - 1;
            while(j > -1 && list[j] > val) {
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = val;
        }
    }

    // min: O(n^2)
    // max: O(n^2)
    // adaptive: false
    // stable: false
    // k pass is useful: true
    public static void selectionSort(int[] list) {
        for(int i = 0 ; i < list.length - 1 ; i++) {
            int j,k;
            for(j = k = i ; j < list.length ; j++) {
                if(list[j] < list[k]) {
                    // swap j and k
                    int temp = list[j];
                    list[j] = list[k];
                    list[k] = temp;
                }
            }
            // swap i and k
            int temp = list[i];
            list[i] = list[k];
            list[k] = temp;
        }
    }

    public static void printList(int[] list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}
