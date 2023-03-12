package com.wayne.datastruct.sortUtils;

public class SortUtils {
    
    // best case: O(n) (if list is already sorted)
    // worst case: O(n^2)
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

    // best case: O(n) (if list is already sorted)
    // worst case: O(n^2)
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

    // best case: O(n^2)
    // worst case: O(n^2)
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

    // base case: O(nlogn) (if partitioning is in middle)
    // worst case: O(n^2) (if list is in ascending or descending order)
    // adaptive: false
    // stable: false
    // k pass is useful: false
    public static void quickSort(int[] list) {
        // clone a new list to add upperbound to list than sort
        int[] copy = new int[list.length + 1];
        for(int i = 0 ; i < list.length ; i++) {
            copy[i] = list[i];
        }
        copy[copy.length - 1] = Integer.MAX_VALUE;
        quickSortRider(copy, 0, copy.length - 1);
        // add back the result to original list
        for(int i = 0 ; i < list.length ; i++) {
            list[i] = copy[i];
        }
    }

    private static void quickSortRider(int[] list, int lo, int hi) {
        if(lo >= hi) return;
        int pivot = partition(list, lo, hi);
        quickSortRider(list, lo, pivot);
        quickSortRider(list, pivot + 1, hi);
    }

    private static int partition(int[] list, int lo, int hi) {
        int i = lo;
        int j = hi;
        do{
            do{i++;} while(list[lo] >= list[i]);
            do{j--;} while(list[lo] < list[j]);
            if(i < j) {
                // swap i and j 
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        } while(i < j);
        // swap lo and j
        int temp = list[lo];
        list[lo] = list[j];
        list[j] = temp;
        // return partioning index
        return j;
    }

    // base case: O(nlogn)
    // worst case: O(nlogn) 
    // adaptive: 
    // stable: 
    // k pass is useful: 
    public static void iterMergeSort(int[] list) {
        int p;
        for(p = 2 ; p <= list.length ; p*=2) {
            for(int i = 0 ; i+p-1 < list.length ; i+=p) {
                int lo = i;
                int hi = i+p-1;
                int mid = (lo + hi) / 2;
                merge(list, lo, mid, hi);
            }
        }
        if(p/2<list.length) { merge(list,0,p/2-1,list.length-1); }
    }

    private static void merge(int[] list, int lo, int mid, int hi) {
        int[] temp = new int[list.length];
        int i = lo;
        int j = mid + 1;
        int k = lo;
        while(i <= mid && j <= hi) {
            if(list[i] < list[j]) temp[k++] = list[i++];
            else temp[k++] = list[j++];
        }
        while(i <= mid) temp[k++] = list[i++];
        while(j <= hi) temp[k++] = list[j++];
        // copy back to original list
        for(int l = lo ; l <= hi ; l++) {
            list[l] = temp[l];
        }
    }

    public static void printList(int[] list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}
