package com.example.practice.didi;

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private String value;

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // 前序遍历
    public void preOrderTraverse1(TreeNode root){
        if(root != null){
            System.out.println(root.value + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }
}





















