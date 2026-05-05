// Last updated: 5/5/2026, 9:34:12 AM
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
12    public ListNode rotateRight(ListNode head, int k) {
13        if(head == null || head.next == null || k== 0){
14            return head;
15        }
16        int n = 1;                                 // find length and tail
17        ListNode tail = head;
18        while(tail.next != null){
19            tail = tail.next;
20            n++;
21        }
22
23        k = k % n;                                 // reduce k
24        if(k == 0){
25            return head;
26        }
27
28        tail.next = head;                           //make circular
29
30        int steps = n-k;                            // find new tail
31        ListNode newTail = head;
32        for(int i=1; i< steps; i++){
33            newTail = newTail.next;
34        }
35
36        ListNode newHead = newTail.next;
37        newTail.next = null;
38
39        return newHead;
40    }
41}