package com.wayne.datastruct.sortUtils;

import com.wayne.datastruct.queue.MyQueue;

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

    // best case: O(nlogn) (if partitioning is in middle)
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

    // best case: O(nlogn)
    // worst case: O(nlogn) 
    // adaptive: 
    // stable: 
    // k pass is useful:
    // extra space: true 
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

    public static void recursiveMergeSort(int[] list) {
        rMergeSortRider(list, 0, list.length - 1);
    }

    private static void rMergeSortRider(int[] list, int lo, int hi) {
        if(lo >= hi) return;
        int mid = (lo + hi) / 2;
        rMergeSortRider(list, lo, mid);
        rMergeSortRider(list, mid + 1, hi);
        merge(list, lo, mid, hi);
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

    // best case: O(n+m)
    // worst case: O(n+m)
    // can't be used by any list which contains negative number
    // !! take lots of space !!
    // bucket(bin) sort is pretty the same, it uses node to count the value instead of storing integer counts
    public static void countSort(int[] list) {
        // find max number
        int max = Integer.MIN_VALUE;
        for(int i: list) {
            max = Integer.max(max, i);
        }
        // default is already fill with 0
        int[] countList = new int[max+1];
        // count the number
        for(int i: list) {
            countList[i]++;
        }
        // put back the number
        int i = 0;
        int j = 0;
        while(j < max+1) {
            if(countList[j] > 0) {
                list[i++] = j;
                countList[j]--;
            } else {
                j++;
            }
        }
    }

    // best case: O(d*n)
    // worst case: O(d*n)
    // pretty fast, only take O(n) time
    // take only O(1) space
    // radix sort is index based, only can sort decimal Integer number, because it is base on the radix
    // (if use comparison base sort algorithm you can sort any thing)
    public static void radixSort(int[] list) {
        // divide into two list(positive and negative list)
        int positiveCount = 0;
        int negativeCount = 0;
        for(int val: list) {
            if(val >= 0) positiveCount++;
            else negativeCount++;
        }
        int[] positiveList = new int[positiveCount];
        int[] negativeList = new int[negativeCount];
        int pI = 0;
        int nI = 0;
        for(int val: list) {
            if(val >= 0) positiveList[pI++] = val;
            else negativeList[nI++] = val;
        }
        // use radix sort on both list
        radixSortMainLogic(positiveList);
        radixSortMainLogic(negativeList);
        int resultIndex = 0;
        // negative list has to be add back in reversed order
        for(int i = negativeList.length - 1 ; i >= 0 ; i--) {
            list[resultIndex++] = negativeList[i];
        }
        // positive list simply add back
        for(int val: positiveList) {
            list[resultIndex++] = val;
        }
    }

    private static void radixSortMainLogic(int[] list) {
        if(list.length <= 1) return;
        MyQueue<Integer>[] radixList = new MyQueue[10];
        // fill the radixList with Queue
        for(int i = 0 ; i < radixList.length ; i++) {
            radixList[i] = new MyQueue<>();
        }
        boolean hasComplete = true;
        int currDevideNum = 1;
        while(true) {
            hasComplete = true;
            // level by level put into radix list
            for(int i = 0 ; i < list.length ; i++) {
                // let negative number follow the same rule and reverse list manually
                int currVal = Math.abs((list[i] / currDevideNum) % 10);
                // try to know if we are at last round
                if(Math.abs(list[i]) / currDevideNum >= 10) hasComplete = false;
                radixList[currVal].enqueue(list[i]);
            }
            // put back to original list follow FIFO rule
            int j = 0;
            for(MyQueue<Integer> q: radixList) {
                while(!q.isEmpty()) {
                    list[j++] = q.dequeue(); 
                }
            }
            if(hasComplete) break;
            currDevideNum *= 10;
        }
    }

    // best case: O(nlogn)
    // worst case: O(nlogn)
    // pretty fast, only take O(n) time
    // kind of like insertion sort
    public static void shellSort(int[] list) {
        int gap = list.length / 2;
        for(; gap >= 1 ; gap/=2) {
            for(int i = gap ; i < list.length ; i++) {
                int currInsertVal = list[i];
                int j = i - gap;
                while(j >= 0 && list[j] > currInsertVal) {
                    list[j + gap] = list[j];
                    j-=gap;
                }
                list[j + gap] = currInsertVal;
            }
        }
    }

    public static void printList(int[] list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}
