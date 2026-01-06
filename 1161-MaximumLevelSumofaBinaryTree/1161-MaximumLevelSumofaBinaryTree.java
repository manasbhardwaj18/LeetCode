// Last updated: 1/6/2026, 7:58:38 PM
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
17    public int maxLevelSum(TreeNode root) {
18        Queue<TreeNode> q = new LinkedList<>();
19        q.add(root); //start
20
21        int max = Integer.MIN_VALUE;
22        int ans = 1, curr = 1;
23
24        while(!q.isEmpty()){
25            int m=0;
26            int size = q.size();
27            for(int a=0;a<size;a++){
28                TreeNode temp = q.remove();
29                m += temp.val;
30                if(temp.left != null){
31                    q.add(temp.left);
32                }
33                if(temp.right != null){
34                    q.add(temp.right);
35                }
36
37            }
38            if(m > max){
39                max = m;
40                ans = curr;
41            }
42            curr += 1;
43        }
44        return ans;
45    }
46}