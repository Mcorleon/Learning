package com.tqh.contest;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicStampedReference;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public static void main(String[] args){
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(5);
        node1.next=node2;
        reverseBetween(node1,1,2);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode pre = null;
        ListNode res = head;
        for (int i = 1; i < m; i++) {
            pre = head;
            head = head.next;
        }
        if (pre != null) {
            pre.next = reverse(head, n - m);
            return res;
        }
        return reverse(head, m - n);
    }

    public static ListNode reverse(ListNode head, int n) {
        ListNode pre = head;
        ListNode begin = head;
        ListNode next = null;
        while (n >= 0) {
            n--;
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            System.out.println(pre.val);
        }
        begin.next = next;
        String s="d";
        return pre;
    }
}