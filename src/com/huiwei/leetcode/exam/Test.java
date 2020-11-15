package com.huiwei.leetcode.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node left = new Node(7);
        Node right = new Node(8);
        Node left1 = new Node(3);
        Node right2 = new Node(2);
        root.left = left;
        root.right = right;
        left.left=left1;
        left.right=right2;
        List<List<Integer>> allpath = new Test().getAllpath(root);
        System.out.println(allpath);
    }

    private List<List<Integer>> allPaths = new ArrayList<>();
    private List<Integer> onePath = new ArrayList<>();

    public List<List<Integer>> getAllpath(Node root) {
        if (root == null) return allPaths;
        onePath.add(root.value);
        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(onePath));
        }
        getAllpath(root.left);
        getAllpath(root.right);
        onePath.remove(onePath.size() - 1);
        return allPaths;
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
