package com.wayne.datastruct;

import com.wayne.datastruct.sortUtils.SortUtils;

public final class App {

    public static void main(String[] args) {
        int[] array = new int[]{3,7,9,10,6,5,12,4,11,2};
        SortUtils.insertionSort(array);
        SortUtils.printList(array);
    }
}
