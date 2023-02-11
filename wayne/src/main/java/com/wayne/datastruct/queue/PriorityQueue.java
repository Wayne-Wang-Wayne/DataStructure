package com.wayne.datastruct.queue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> {
    
    MyQueue<T> firstQ = new MyQueue<>();
    MyQueue<T> secondQ = new MyQueue<>();
    MyQueue<T> thirdQ = new MyQueue<>();
    MyQueue<T> fourthQ = new MyQueue<>();
    MyQueue<T> fifthQ = new MyQueue<>();
    MyQueue<T> sixthQ = new MyQueue<>();
    List<MyQueue<T>> allQs;
    public PriorityQueue(){
        allQs = new ArrayList<>();
        allQs.add(firstQ);
        allQs.add(secondQ);
        allQs.add(thirdQ);
        allQs.add(fourthQ);
        allQs.add(fifthQ);
        allQs.add(sixthQ);
    }

    public enum Priority {
        FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH
    }

    public void display() {
        for(MyQueue<T> q : allQs) {
            q.display();
        }
    }

    public int getSize() {
        int sumSize = 0;
        for(MyQueue<T> q : allQs) {
            sumSize += q.size;
        }
        return sumSize;
    }

    public boolean isEmpty() {
        boolean result = true;
        for(MyQueue<T> q : allQs) {
            result = result && q.isEmpty();
        }
        return result;
    }
    
    public void enqueue(Priority priority, T val) {
        switch(priority) {
            case FIRST: {
                firstQ.enqueue(val);
                break;
            }
            case SECOND: {
                secondQ.enqueue(val);
                break;
            }
            case THIRD: {
                thirdQ.enqueue(val);
                break;
            }
            case FOURTH: {
                fourthQ.enqueue(val);
                break;
            }
            case FIFTH: {
                fifthQ.enqueue(val);
                break;
            }
            case SIXTH: {
                sixthQ.enqueue(val);
                break;
            }
        }
    }

    public T dequeue() {
        T outPut = null;
        for(MyQueue<T> q : allQs) {
            outPut = q.dequeue();
            if(outPut != null) return outPut;
        }
        System.out.println("Priority Queue is empty!!");
        return outPut;
    }
}
