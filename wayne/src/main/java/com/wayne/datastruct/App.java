package com.wayne.datastruct;

import com.wayne.datastruct.array.MyArrayList;
import com.wayne.datastruct.doublyLinkedList.CircularDoublyLinkedList;
import com.wayne.datastruct.doublyLinkedList.DoublyLinkedList;
import com.wayne.datastruct.linkedList.CircularLinkedList;
import com.wayne.datastruct.linkedList.MyLinkedList;
import com.wayne.datastruct.stack.CustomCharStack;
import com.wayne.datastruct.stack.MyStack;

public final class App {

    public static void main(String[] args) {
        CustomCharStack stack = new CustomCharStack();
        String postfix = stack.infixToPostfix("((a+b)*c)-d^e^f");
        System.out.println(postfix);
    }
}
