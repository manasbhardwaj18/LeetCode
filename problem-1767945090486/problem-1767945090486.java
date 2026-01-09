// Last updated: 1/9/2026, 1:21:30 PM
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
17    class Sol{
18        TreeNode node;
19        int level;
20        Sol(TreeNode n, int x){
21            node = n;
22            level = x;
23        }
24    }
25    public TreeNode subtreeWithAllDeepest(TreeNode root) {
26        return dfs(root).node;
27    }
28
29    private Sol dfs(TreeNode node){
30        if(node == null){
31            return new Sol(null, 0);
32        }
33        Sol left = dfs(node.left);
34        Sol right = dfs(node.right);
35
36        if(left.level > right.level){
37            return new Sol(left.node, left.level+1);
38        }else if(right.level > left.level){
39            return new Sol(right.node,right.level+1);
40        }else{
41            return new Sol(node, left.level+1);
42        }
43    }
44}