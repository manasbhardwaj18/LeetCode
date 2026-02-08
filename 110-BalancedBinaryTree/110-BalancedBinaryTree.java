// Last updated: 2/8/2026, 10:38:40 AM
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
18        int[] result = dfs(root);
19        return result[0] == 1;        
20    }
21
22    private int[] dfs(TreeNode node) {
23        if (node == null) return new int[]{1, 0};
24        
25        int[] left = dfs(node.left);
26        int[] right = dfs(node.right);
27        
28        boolean isBalanced = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1;
29        
30        return new int[]{isBalanced ? 1 : 0, 1 + Math.max(left[1], right[1])};
31    }    
32}