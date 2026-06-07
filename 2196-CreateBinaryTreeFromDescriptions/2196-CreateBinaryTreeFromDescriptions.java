// Last updated: 6/7/2026, 10:55:58 AM
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
17    public TreeNode createBinaryTree(int[][] descriptions) {
18        HashMap<Integer, TreeNode> one = new HashMap<>();
19        HashMap<Integer, Integer> two = new HashMap<>();
20
21        for(int[] des : descriptions){
22            int parent = des[0];
23            int child = des[1];
24            int isLeft = des[2];
25
26            if(!one.containsKey(parent)){
27                one.put(parent, new TreeNode(parent));
28            }
29            if(!one.containsKey(child)){
30                one.put(child, new TreeNode(child));
31            }
32            if(isLeft == 1){
33                one.get(parent).left = one.get(child);
34            }else{
35                one.get(parent).right = one.get(child);
36            }
37
38            if(two.getOrDefault(parent,0) != -1){
39                two.put(parent, 1);
40            }
41
42            two.put(child, -1);
43        }
44        int root = 0;
45        for(var entry : two.entrySet()){
46            if(entry.getValue() == 1){
47                root = entry.getKey();
48                break;
49            }
50        }
51        return one.get(root);
52    }
53}