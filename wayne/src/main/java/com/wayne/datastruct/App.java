package com.wayne.datastruct;

import com.wayne.datastruct.array.MyArrayList;
import com.wayne.datastruct.doublyLinkedList.CircularDoublyLinkedList;
import com.wayne.datastruct.doublyLinkedList.DoublyLinkedList;
import com.wayne.datastruct.heap.MyHeap;
import com.wayne.datastruct.linkedList.CircularLinkedList;
import com.wayne.datastruct.linkedList.MyLinkedList;
import com.wayne.datastruct.queue.DEQueue;
import com.wayne.datastruct.queue.MyQueue;
import com.wayne.datastruct.queue.PriorityQueue;
import com.wayne.datastruct.sortUtils.SortUtils;
import com.wayne.datastruct.stack.CustomCharStack;
import com.wayne.datastruct.stack.MyStack;
import com.wayne.datastruct.tree.AVLTree;
import com.wayne.datastruct.tree.BSTree;
import com.wayne.datastruct.tree.MyTree;

public final class App {

    public static void main(String[] args) {
        int[] array = new int[]{3,7,9,10,6,5,12,4,11,2};
        SortUtils.bubbleSort(array);
        SortUtils.printList(array);
    }
}
