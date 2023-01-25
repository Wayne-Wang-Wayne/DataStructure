package com.wayne.datastruct.linkedList;

import java.util.Scanner;

public class MyLinkedList {
    int size = 0;
    Node<Integer> head;
    Node<Integer> tail;

    public MyLinkedList() {
    }

    public MyLinkedList(int size) {
        if (size == 0)
            return;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values");
        int inPut = sc.nextInt();
        Node<Integer> p = new Node<Integer>(inPut);
        head = p;
        for (int i = 1; i < size; i++) {
            inPut = sc.nextInt();
            p.next = new Node<Integer>(inPut);
            p = p.next;
        }
        this.size = size;
        tail = p;
        sc.close();
    }

    public void display() {
        if (isEmpty())
            return;
        Node<Integer> temp = head;
        System.out.print("Your LinkedList: ");
        while (temp != null) {
            System.out.print(String.valueOf(temp.value) + " ");
            temp = temp.next;
        }
    }

    public void rDisplay() {
        System.out.print("Your LinkedList: ");
        rDisplayHelper(head);
    }

    public int sum() {
        int sum = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            sum += temp.value;
            temp = temp.next;
        }
        return sum;
    }

    public int rSum() {
        return rSumHelper(head);
    }

    public Node<Integer> search(int value) {
        Node<Integer> temp = head;
        Node<Integer> last = null;
        while (temp != null) {
            if (temp.value == value) {
                // if found move to first
                if (temp != head) {
                    last.next = temp.next;
                    temp.next = head;
                    head = temp;
                }
                return head;
            }
            last = temp;
            temp = temp.next;
        }
        return null;
    }

    public void insert(int index, int val) {
        if (index > size || index < 0)
            return;
        Node<Integer> temp = new Node<Integer>(val);
        Node<Integer> p = head;
        if (index == 0) {
            temp.next = head;
            head = temp;
        } else {
            for (int i = 0; i < index - 1; i++)
                p = p.next;
            temp.next = p.next;
            p.next = temp;
            if (temp.next == null)
                tail = temp;
        }
        size++;
    }

    public void insertAtLast(int val) {
        Node<Integer> temp = new Node<Integer>(val);
        if (isEmpty()) {
            head = temp;
            tail = temp;
            size++;
            return;
        }
        tail.next = temp;
        tail = temp;
        size++;
    }

    public int delete(int index) {
        int val = -1;
        Node<Integer> curr = head;
        Node<Integer> pre = null;
        if (index < 0 || index >= size)
            return val;
        size--;
        if (index == 0) {
            val = head.value;
            head = head.next;
            return val;
        } else {
            for (int i = 0; i < index; i++) {
                pre = curr;
                curr = curr.next;
            }
            pre.next = curr.next;
            return curr.value;
        }
    }

    public boolean isSorted() {
        int preVal = Integer.MIN_VALUE;
        Node<Integer> curr = head;
        while (curr != null) {
            if (preVal > curr.value)
                return false;
            preVal = curr.value;
            curr = curr.next;
        }
        return true;
    }

    // only can be use when linkedList is sorted.
    public void deleteDuplicateFormSoted() {
        if (!isSorted())
            return;
        Node<Integer> curr = head;
        Node<Integer> next = head.next;
        while (next != null) {
            if (curr.value == next.value) {
                curr.next = next.next;
                next = curr.next;
            } else {
                curr = next;
                next = next.next;
            }
        }
    }

    public void reverse() {
        Node<Integer> curr = null;
        Node<Integer> pre = null;
        Node<Integer> next = head;
        while (next != null) {
            pre = curr;
            curr = next;
            next = next.next;
            curr.next = pre;
        }
        head = curr;
    }

    public void rReverse() {
        rReverseHelper(null, head);
    }

    public MyLinkedList concat(MyLinkedList secList) {
        if (secList == null)
            return this;
        Node<Integer> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = secList.head;
        return this;
    }

    public MyLinkedList merge(MyLinkedList secList) {
        if (secList == null)
            return this;
        if (secList.isEmpty() || isEmpty() || !isSorted() || !secList.isSorted())
            return this;
        Node<Integer> mergeHead = null;
        Node<Integer> mergeTail = null;
        Node<Integer> head1 = head;
        Node<Integer> head2 = secList.head;
        if (head1.value <= head2.value) {
            mergeHead = mergeTail = head1;
            head1 = head1.next;
        } else {
            mergeHead = mergeTail = head2;
            head2 = head2.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                mergeTail.next = head1;
                mergeTail = head1;
                head1 = head1.next;
            } else {
                mergeTail.next = head2;
                mergeTail = head2;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            mergeTail.next = head2;
        } else {
            mergeTail.next = head1;
        }
        head = mergeHead;
        return this;
    }

    private boolean isEmpty() {
        return size <= 0;
    }

    private void rDisplayHelper(Node<Integer> node) {
        if (node == null)
            return;
        System.out.print(String.valueOf(node.value) + " ");
        rDisplayHelper(node.next);
    }

    private int rSumHelper(Node<Integer> node) {
        if (node == null)
            return 0;
        return rSumHelper(node.next) + node.value;
    }

    private void rReverseHelper(Node<Integer> pre, Node<Integer> curr) {
        if (curr == null) {
            head = pre;
            return;
        }
        rReverseHelper(curr, curr.next);
        curr.next = pre;
    }
}
