package com.huiwei.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int length = 0;
        int max = 0;
        for (int i = 0; i < chars.length ; i++) {
            if(set.contains(chars[i])){
                set.clear();
                if(max < length){
                    max = length;
                }
                length=1;
            }else {
                length++;
            }
            set.add(chars[i]);
        }
        return max;
    }
}
