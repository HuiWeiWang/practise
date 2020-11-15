package com.huiwei.leetcode;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.addNext(new ListNode(4));
        l1.addNext(new ListNode(3));
        ListNode l2 = new ListNode(5);
        l2.addNext(new ListNode(6));
        l2.addNext(new ListNode(4));
        ListNode listNode = addTwoNumbers(l1, l2);
        listNode.print(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        int carry = 0;
        while (l1!=null || l2!=null || carry!=0){
            int val1 = l1!=null ? l1.val : 0;
            int val2 = l2!=null ? l2.val : 0;
            int sum = val1+val2+carry;
            carry=sum/10;
            ListNode newNode = new ListNode(sum%10);
            cursor.next=newNode;
            cursor = newNode;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return dummy.next;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode addNext(ListNode next){
            ListNode cursor = this;
            while (cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = next;
            return next;
        }

        public void print(ListNode node){
            StringBuilder sb = new StringBuilder();
            while(node != null){
                sb.append(node.val);
                node = node.next;
            }
            System.out.println(sb.toString());
        }
    }
}
