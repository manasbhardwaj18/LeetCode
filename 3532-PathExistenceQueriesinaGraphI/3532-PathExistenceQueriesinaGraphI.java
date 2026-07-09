// Last updated: 7/9/2026, 7:23:11 PM
1class Solution {
2    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] q) {
3        boolean ans[] = new boolean[q.length]; 
4        int root[] = new int[nums.length]; 
5        root[0] = 0; 
6        for(int i = 1; i < nums.length; i++) {
7            root[i] = ((nums[i] - nums[i - 1]) <= maxDiff) ? root[i - 1] : i; 
8        }
9
10        for(int i = 0; i < q.length; i++) {
11            ans[i] = root[q[i][0]] == root[q[i][1]]; 
12        }
13        return ans; 
14    }
15}