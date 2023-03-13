package com.wayne.datastruct;

import com.wayne.datastruct.sortUtils.SortUtils;

public final class App {

    public static void main(String[] args) {
        int[] array = new int[]{333,7,921,-300,10,-6,0,5000,12,-1,40,-100,11,2,1,8,15};
        SortUtils.shellSort(array);
        SortUtils.printList(array);
    }
}
