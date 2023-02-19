package com.wayne.datastruct.tree;
import com.wayne.datastruct.queue.MyQueue;
import com.wayne.datastruct.stack.MyStack;

import java.util.Scanner;

public class MyTree {
    TreeNode<Integer> root;

    public void createTree() {
        System.out.println("Please enter root value.");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        root = new TreeNode<>();
        root.value = input;
        MyQueue<TreeNode<Integer>> queue = new MyQueue<>();
        queue.enqueue(root);
        while(!queue.isEmpty()) {
            TreeNode<Integer> currNode = queue.dequeue();
            System.out.println("Please enter " + currNode.value + "'s left child value");
            input = sc.nextInt();
            if(input != -1) {
                TreeNode<Integer> left = new TreeNode<>();
                left.value = input;
                currNode.left = left;
                queue.enqueue(left);
            }
            System.out.println("Please enter " + currNode.value + "'s right child value");
            input = sc.nextInt();
            if(input != -1) {
                TreeNode<Integer> right = new TreeNode<>();
                right.value = input;
                currNode.right = right;
                queue.enqueue(right);
            }
        }
        sc.close();
    }

    public void preOrder() {
        System.out.println("PreOrder");
        preOrderRider(root);
    }

    private void preOrderRider(TreeNode<Integer> node) {
        if(node == null) return;
        System.out.println(node.value);
        preOrderRider(node.left);
        preOrderRider(node.right);
    }

    public void iTPreOrder() {
        System.out.println("PreOrder");
        if(root == null) return;
        MyStack<TreeNode<Integer>> stack = new MyStack<>();
        TreeNode<Integer> t = root;
        while(!stack.isEmpty() || t != null) {
            if(t != null) {
                System.out.println(t.value);
                stack.push(t);
                t = t.left; 
            } else {
                t = stack.pop().right;
            }
        }   
    }

    public void inOrder() {
        System.out.println("InOrder");
        inOrderRider(root);
    }

    private void inOrderRider(TreeNode<Integer> node) {
        if(node == null) return;
        inOrderRider(node.left);
        System.out.println(node.value);
        inOrderRider(node.right);
    }

    public void iTInOrder() {
        System.out.println("InOrder");
        MyStack<TreeNode<Integer>> stack = new MyStack<>();
        TreeNode<Integer> t = root;
        while(t != null || !stack.isEmpty()) {
            if(t != null) {
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                System.out.println(t.value);
                t = t.right;
            }
        }
    }

    public void postOrder() {
        System.out.println("PostOrder");
        postOrderRider(root);
    }

    private void postOrderRider(TreeNode<Integer> node) {
        if(node == null) return;
        postOrderRider(node.left);
        postOrderRider(node.right);
        System.out.println(node.value);
    }

    public void iTPostOrder() {
        System.out.println("PostOrder");
        MyStack<TreeNode<Integer>> s1 = new MyStack<>();
        MyStack<TreeNode<Integer>> s2 = new MyStack<>();
        TreeNode<Integer> t = root;
        s1.push(t);
        while(!s1.isEmpty()) {
            t = s1.pop();
            s2.push(t);
            if(t.left != null) {
                s1.push(t.left);
            }
            if(t.right != null) {
                s1.push(t.right);
            }
        }
        while(!s2.isEmpty()) {
            System.out.println(s2.pop().value);
        }
    }

    public void levelOrder() {
        System.out.println("LevelOrder");
        MyQueue<TreeNode<Integer>> queue = new MyQueue<>();
        queue.enqueue(root);
        System.out.println(root.value);
        while(!queue.isEmpty()) {
            TreeNode<Integer> currNode = queue.dequeue();
            if(currNode.left != null) {
                System.out.println(currNode.left.value);
                queue.enqueue(currNode.left);
            }
            if(currNode.right != null) {
                System.out.println(currNode.right.value);
                queue.enqueue(currNode.right);
            }
        }
    }

    public int height() {
       return heightRider(root);
    }

    private int heightRider(TreeNode<Integer> node) {
        if(node == null) return 0;
        return Math.max(heightRider(node.left), heightRider(node.left)) + 1;
    }
}
