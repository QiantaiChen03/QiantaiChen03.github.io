package com.leetcode.LinkedList;

import java.util.HashMap;
import java.util.HashSet;

public class Q1836 {
    //Remove Duplicates From an Unsorted Linked List
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode (int val) {
            this.val = val;
        }
        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicatesUnsorted (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //HashMap<Integer,Integer> hashmap = new HashMap<>();
        HashSet<Integer> appeared = new HashSet<>();
        HashSet<Integer> duplicate = new HashSet<>();
        ListNode curr = head;
        while(head != null) {
            if (appeared.contains(head.val)) {
                //System.out.print(head.val);
                duplicate.add(head.val);
            } else {
                appeared.add(head.val);
            }
            head = head.next;
        }
        ListNode temp = new ListNode(0, curr);
        ListNode pred = temp;

        while (curr != null) {
            if (duplicate.contains(curr.val)){
                pred.next = curr.next;
            } else if (!duplicate.contains(curr.val)){
                pred = pred.next;
            }
            curr = curr.next;
        }
        return temp.next;
    }


}
