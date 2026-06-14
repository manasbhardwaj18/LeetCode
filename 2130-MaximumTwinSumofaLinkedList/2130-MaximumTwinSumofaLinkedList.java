// Last updated: 6/14/2026, 11:47:14 AM
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
12    public int pairSum(ListNode head) {
13        ListNode slow = head, fast = head, prev = null;
14        while(fast != null && fast.next != null){
15            fast = fast.next.next;
16            ListNode temp = slow.next;
17            slow.next = prev;
18            prev = slow;
19            slow = temp;
20        }
21        int res = 0;
22        while(slow != null){
23            res = Math.max(res, prev.val + slow.val);
24            prev = prev.next;
25            slow = slow.next;
26        }
27        return res;
28    }
29}