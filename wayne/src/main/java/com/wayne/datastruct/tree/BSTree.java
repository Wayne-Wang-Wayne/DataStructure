package com.wayne.datastruct.tree;

public class BSTree {
    TreeNode<Integer> root;


    public void rInsert(int val) {
        root = rInsertRider(val, root);
    }

    private TreeNode<Integer> rInsertRider(int val, TreeNode<Integer> node) {
        if(node == null) {
            return new TreeNode<Integer>(val);
        }
        if(val > node.value) {
            node.right = rInsertRider(val, node.right);
        } else if(val < node.value) {
            node.left = rInsertRider(val, node.left);
        } 
        return node;
    }

    public void insert(int val) {
        TreeNode<Integer> curr = root;
        TreeNode<Integer> pre = null;
        if(root == null) {
            root = new TreeNode<>(val);
            return;
        }
        while(curr != null) {
            if(curr.value == val) return;
            pre = curr;
            if(val > curr.value) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        curr = new TreeNode<Integer>(val);
        if(val > pre.value) pre.right = curr;
        else pre.left = curr;
    }

    public TreeNode<Integer> search(int val) {
        TreeNode<Integer> curr = root;
        while(curr != null) {
            if(curr.value == val) return curr;
            if(val > curr.value) curr = curr.right;
            else curr = curr.left;
        }
        return null;
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
}
