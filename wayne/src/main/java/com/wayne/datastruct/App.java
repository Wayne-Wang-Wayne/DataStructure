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

public final class App {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(PriorityQueue.Priority.FIRST,1);
        queue.enqueue(PriorityQueue.Priority.SECOND,2);
        queue.enqueue(PriorityQueue.Priority.THIRD,3);
        queue.enqueue(PriorityQueue.Priority.FOURTH,4);
        queue.enqueue(PriorityQueue.Priority.FIFTH,5);
        queue.enqueue(PriorityQueue.Priority.SIXTH,6);
        queue.enqueue(PriorityQueue.Priority.FIRST, 7);
        queue.dequeue();
        queue.dequeue();
        queue.display();
    }
}
