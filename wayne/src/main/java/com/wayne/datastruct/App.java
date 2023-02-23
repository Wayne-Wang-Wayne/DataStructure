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
        tree.insert(0);
        tree.insert(4);
        tree.insert(100);
        tree.insert(55);
        tree.insert(90);
        tree.insert(60);
        tree.insert(20);
        tree.inOrder();
    }
}
