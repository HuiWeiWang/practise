package com.huiwei.arth.datastructure.tree;

public class HuffmanTree {

    public static void main(String[] args) {

        int arr[] = new int[]{13,7,8,3,29,6,1};
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        for (Byte b : bytes) {
            System.out.println(b);
        }
    }


}

class Node implements Comparable<Node>{
    Byte Data;
    Integer weight;

    public Node(Byte data, int weight) {
        Data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight.compareTo(o.weight);
    }
}
