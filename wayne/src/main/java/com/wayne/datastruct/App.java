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
import com.wayne.datastruct.tree.AVLTree;
import com.wayne.datastruct.tree.BSTree;
import com.wayne.datastruct.tree.MyTree;

public final class App {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(0);
        
        System.out.println(tree.toString());
    }
}
