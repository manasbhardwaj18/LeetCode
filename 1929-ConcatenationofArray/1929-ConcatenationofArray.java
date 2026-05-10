// Last updated: 5/10/2026, 1:20:08 PM
1class Solution {
2    public int[] shuffle(int[] nums, int n) {
3        int[] res = new int[2*n];
4        for(int i=0; i<n; i++){
5            res[2*i] = nums[i];
6            res[2*i+1] = nums[i+n];
7        }
8        return res;
9    }
10}