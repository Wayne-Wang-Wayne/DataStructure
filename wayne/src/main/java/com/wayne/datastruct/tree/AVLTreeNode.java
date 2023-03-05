package com.wayne.datastruct.tree;

public class AVLTreeNode<T> {
    public AVLTreeNode<T> left;
    public AVLTreeNode<T> right;
    public int height = 1;
    public T value;
    public AVLTreeNode(T value){
        this.value = value;
    }
}
