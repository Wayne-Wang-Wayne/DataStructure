package com.wayne.datastruct.tree;

public class AVLTree {

    AVLTreeNode<Integer> root;

    public void insert(int val) {
        insertRider(val, root);
    }

    private AVLTreeNode<Integer> insertRider(int val, AVLTreeNode<Integer> node) {
        if(node == null) {
            AVLTreeNode<Integer> t = new AVLTreeNode<Integer>(val);
            if(root == null) root = t;
            return t;
        }

        if(val > node.value) {
            node.right = insertRider(val, node.right);
        } else if(val < node.value) {
            node.left = insertRider(val, node.left);
        } 

        // calculate balance factor and perform rotation if need and update new height
        if(getBalanceFactor(node) >= 2 && getBalanceFactor(node.left) >= 1) {
            // perform LLRotation
            return LLRotation(node);
        } else if(getBalanceFactor(node) >= 2 && getBalanceFactor(node.left) <= -1) {
            // perform LRRotation
            return LRRotation(node);
        } else if(getBalanceFactor(node) <= -2 && getBalanceFactor(node.right) >= 1) {
            // perform RLRotation
            return RLRotation(node);
        } else if(getBalanceFactor(node) <= -2 && getBalanceFactor(node.right) <= -1) {
            // perform RRRotation
            return RRRotation(node);
        }
        
        return node;
    }

    public int getHeight(AVLTreeNode<Integer> node) {
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int getBalanceFactor(AVLTreeNode<Integer> node) {
        if(node == null) return 0;
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);
        return lHeight - rHeight;
    }

    private AVLTreeNode<Integer> LLRotation(AVLTreeNode<Integer> node) {
        AVLTreeNode<Integer> l = node.left;
        AVLTreeNode<Integer> lr = l.right;
        AVLTreeNode<Integer> newRoot = l;
        newRoot.right = node;
        node.left = lr;
        newRoot.height = getHeight(newRoot);
        node.height = getHeight(node);
        if(node == root) root = newRoot;
        return newRoot;
    }

    private AVLTreeNode<Integer> RRRotation(AVLTreeNode<Integer> node) {
        AVLTreeNode<Integer> r = node.right;
        AVLTreeNode<Integer> rl = r.left;
        AVLTreeNode<Integer> newRoot = r;
        newRoot.left = node;
        node.right = rl;
        newRoot.height = getHeight(newRoot);
        node.height = getHeight(node);
        if(node == root) root = newRoot;
        return newRoot;
    }

    private AVLTreeNode<Integer> LRRotation(AVLTreeNode<Integer> node) {
        AVLTreeNode<Integer> l = node.left;
        AVLTreeNode<Integer> lr = l.right;
        AVLTreeNode<Integer> newRoot = lr;
        l.right = lr.left;
        node.left = lr.right;
        newRoot.left = l;
        newRoot.right = node;
        l.height = getHeight(l);
        node.height = getHeight(node);
        newRoot.height = getHeight(newRoot);
        if(node == root) root = newRoot;
        return newRoot;
    }

    private AVLTreeNode<Integer> RLRotation(AVLTreeNode<Integer> node) {
        AVLTreeNode<Integer> r = node.right;
        AVLTreeNode<Integer> rl = r.left;
        AVLTreeNode<Integer> newRoot = rl;
        r.left = rl.right;
        node.right = rl.left;
        newRoot.right = r;
        newRoot.left = node;
        r.height = getHeight(r);
        node.height = getHeight(node);
        newRoot.height = getHeight(newRoot);
        if(node == root) root = newRoot;
        return newRoot;
    }
}
