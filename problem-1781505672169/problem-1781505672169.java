// Last updated: 6/15/2026, 12:11:12 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode deleteMiddle(ListNode head) {
13        if(head.next == null) return null;
14
15        ListNode slow = head;
16        ListNode fast = slow.next.next;
17
18        while(fast != null && fast.next != null){
19            slow = slow.next;
20            fast = fast.next.next;
21        }
22
23        slow.next = slow.next.next;
24        return head;
25    }
26}