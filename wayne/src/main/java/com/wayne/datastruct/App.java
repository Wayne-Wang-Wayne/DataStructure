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
import com.wayne.datastruct.stack.CustomCharStack;
import com.wayne.datastruct.stack.MyStack;
import com.wayne.datastruct.tree.AVLTree;
import com.wayne.datastruct.tree.BSTree;
import com.wayne.datastruct.tree.MyTree;

public final class App {

    public static void main(String[] args) {
        MyHeap heap = new MyHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(25);
        heap.insert(5);
        heap.insert(40);
        heap.insert(35);
        heap.delete();
        heap.print();
        int[] sortedArray = heap.heapSortTheRest();
        for(int i = 0 ; i < sortedArray.length ; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }
}
