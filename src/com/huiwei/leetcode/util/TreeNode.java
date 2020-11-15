package com.huiwei.leetcode.util;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public static TreeNode newRootTreeNodeInstance(){
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(1);
        TreeNode left3 = new TreeNode(8);
        root.left=left1;
        root.right=right1;
        left1.left=left2;
        left1.right=right2;
        right1.left=left3;
        return root;
    }
}
