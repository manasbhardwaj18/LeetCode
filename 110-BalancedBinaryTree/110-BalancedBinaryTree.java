// Last updated: 2/8/2026, 10:41:31 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean isBalanced(TreeNode root) {
18        return dfs(root) != -1;
19    }
20
21    int dfs(TreeNode node){
22        if(node == null){
23            return 0;
24        }
25        int left = dfs(node.left);
26        if(left == -1){
27            return -1;
28        }
29        int right = dfs(node.right);
30        if(right == -1){
31            return -1;
32        }
33
34        if(Math.abs(left - right) > 1){
35            return -1;
36        }
37
38        return 1+Math.max(left,right);
39    }
40}