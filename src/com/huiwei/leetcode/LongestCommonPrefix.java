package com.huiwei.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        //1���ҳ�������С��
        int minLength = getMinLength(strs);
        //2��ѭ��min��
        outer:
        for (int i = 0; i < minLength ; i++) {
            char eqa = strs[0].charAt(i);
            for (int j = 1; j < strs.length ; j++) {
                if(eqa!=strs[j].charAt(i)){
                    break outer;
                }
            }
            prefix += eqa;
        }
        return prefix;
    }

    /**
     * �ҳ���С����
     * @param strs
     * @return
     */
    private static int getMinLength(String[] strs) {
        int min =strs[0].length();
        for (int i = 0; i < strs.length ; i++) {
            min = strs[i].length() < min ? strs[i].length():min;
        }
        return min;
    }
}
