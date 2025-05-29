/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ArrayList<Integer> res = new ArrayList<>(); 
    public Solution(ListNode head) { 
        while(head != null){ 
            res.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() { 

        return res.get((int)(Math.random() * res.size()));
    }
}