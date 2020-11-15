package com.huiwei.leetcode.exam;

import java.util.ArrayList;
import java.util.List;

public class FindAllBTPath {

    //��¼����·��
    private List<List<Integer>> allPaths = new ArrayList<>();

    //��¼ÿ��·��
    private List<Integer> onePath = new ArrayList<>();

    //��������·��
    public List<List<Integer>> findAllPath(TreeNode root) {
        //�ݹ�ͷ
        if (root == null) return allPaths;

        //�ѵ�ǰ�ڵ�ӵ�·������
        onePath.add(root.val);
        // ���ΪҶ�ӽ�㣬���onePath���뵽allPaths����
        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(onePath));
        }

        findAllPath(root.left);
        findAllPath(root.right);
        // ����ط�����ͨ�����ݹ�������⣬����Ҷ�ӽ�������㻹���ҽ�㣬���ᾭ��������һ��������������Ҫ
        onePath.remove(onePath.size() - 1);
        return allPaths;
    }


    public List<List<Integer>> findAllPath2(TreeNode root) {
        if(root==null) return allPaths;
        onePath.add(root.val);
        if(root.left==null&&root.right==null){
            allPaths.add(new ArrayList<>(onePath));
        }
        findAllPath2(root.left);
        findAllPath2(root.right);
        onePath.remove(onePath.size()-1);
        return allPaths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(5);
        root.left=left1;
        root.right=right1;
      /*  TreeNode left2 = new TreeNode(7);
        TreeNode right2 = new TreeNode(8);
        left1.left=left2;
        left1.right=right2;
        TreeNode left3 = new TreeNode(10);
        right2.left=left3;*/
        List<List<Integer>> allPath = new FindAllBTPath().findAllPath2(root);
        for (List<Integer> onePath:allPath){
            StringBuilder onePathStr = new StringBuilder();
            for (Integer i:onePath){
                onePathStr.append(i).append("--->");
            }
            String s = onePathStr.toString();
            System.out.println(s.substring(0,s.length()-4));
        }
    }


}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
