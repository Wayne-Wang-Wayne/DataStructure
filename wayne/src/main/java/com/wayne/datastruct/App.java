package com.wayne.datastruct;

import com.wayne.datastruct.array.MyArrayList;
import com.wayne.datastruct.doublyLinkedList.CircularDoublyLinkedList;
import com.wayne.datastruct.doublyLinkedList.DoublyLinkedList;
import com.wayne.datastruct.linkedList.CircularLinkedList;
import com.wayne.datastruct.linkedList.MyLinkedList;
import com.wayne.datastruct.queue.DEQueue;
import com.wayne.datastruct.queue.MyQueue;
import com.wayne.datastruct.queue.PriorityQueue;
import com.wayne.datastruct.stack.CustomCharStack;
import com.wayne.datastruct.stack.MyStack;
import com.wayne.datastruct.tree.BSTree;
import com.wayne.datastruct.tree.MyTree;

public final class App {

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.rInsert(0);
        tree.rInsert(4);
        tree.rInsert(100);
        tree.rInsert(55);
        tree.rInsert(90);
        tree.rInsert(60);
        tree.rInsert(20);
        tree.inOrder();
    }
}
