// Last updated: 2/9/2026, 12:03:51 PM
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
17    void inorder(TreeNode node, List<Integer> v){
18        if(node == null) {
19            return ;
20        }
21        inorder(node.left, v);
22        v.add(node.val);
23        inorder(node.right, v);
24    }
25    TreeNode build(List<Integer> v, int l , int r){
26        if(l > r){
27            return null;
28        }
29        int mid = (l+r)/2;
30        TreeNode node = new TreeNode(v.get(mid));
31        node.left = build(v,l,mid-1);
32        node.right = build(v,mid+1,r);
33        return node; 
34    }
35    public TreeNode balanceBST(TreeNode root) {
36        List<Integer> v = new ArrayList<>();
37        inorder(root, v);
38        return build(v,0,v.size()-1);
39    }
40}