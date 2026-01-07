// Last updated: 1/7/2026, 1:23:12 PM
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
17    long total = 0;
18    long maxP = 0;
19    int MOD = 1000000007;
20
21    public long getTotal(TreeNode root){
22        if(root == null){
23            return 0;
24        }
25        return root.val + getTotal(root.left) + getTotal(root.right);
26    }
27    public long dfs(TreeNode root){
28        if(root == null){
29            return 0;
30        }
31        long lf = dfs(root.left);
32        long rt = dfs(root.right);
33
34        long subSum = root.val + lf + rt;
35        maxP = Math.max(maxP, subSum*(total - subSum));
36        return subSum;
37    } 
38
39    public int maxProduct(TreeNode root) {
40        total = getTotal(root);
41        dfs(root);
42        return (int)(maxP % MOD);
43    }
44}