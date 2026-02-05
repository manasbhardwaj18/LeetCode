// Last updated: 2/5/2026, 1:13:09 PM
1class Solution {
2    public int[] constructTransformedArray(int[] nums) {
3        int n = nums.length;
4        int[] ans = new int[n];
5
6        for(int i=0;i<n;i++){
7            ans[i] = nums[((i+nums[i]) % n+n) % n];
8        }
9        return ans;
10    }
11}