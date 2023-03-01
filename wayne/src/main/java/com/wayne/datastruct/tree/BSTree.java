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

    public int getHeight() {
        return getHeightRider(root);
    }

    private int getHeightRider(TreeNode<Integer> node) {
        if(node == null) return 0;
        return Math.max(getHeightRider(node.left), getHeightRider(node.right)) + 1;
    }

    public TreeNode<Integer> delete(int val) {
       return deleteRider(root, val);
    }

    private TreeNode<Integer> findInorderPred(TreeNode<Integer> node) {
        node = node.left;
        while(node != null && node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode<Integer> findInorderSucc(TreeNode<Integer> node) {
        node = node.right;
        while(node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode<Integer> deleteRider(TreeNode<Integer> node, int val) {
        if(node == null) return null;       
        if(node.left == null && node.right == null && node.value == val) {
            // delete leaf node if target is found
            if(node == root) root = null;
            return null;
        }
        if(val > node.value) {
            node.right = deleteRider(node.right, val);
        } else if(val < node.value) {
            node.left = deleteRider(node.left, val);
        } else {
            if(getHeightRider(node.left) > getHeightRider(node.right)) {
                // delete inorder predecessor
                TreeNode<Integer> pred = findInorderPred(node);
                node.value = pred.value;
                node.left = deleteRider(node.left, pred.value);
            } else {
                // delete inorder successor
                TreeNode<Integer> succ = findInorderSucc(node);
                node.value = succ.value;
                node.right = deleteRider(node.right, succ.value);
            }
        }
        return node;
    }
}
