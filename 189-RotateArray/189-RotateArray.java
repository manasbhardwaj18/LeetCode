// Last updated: 5/7/2026, 10:38:29 AM
1class Solution {
2    public void rotate(int[] nums, int k) {
3        int n = nums.length;
4        k = k % n;
5        int[] rotated = new int[n];
6
7        for(int i=0; i<n; i++){
8            rotated[(i+k) % n] = nums[i];
9        }
10
11        for(int i=0; i<n; i++){
12            nums[i] = rotated[i];
13        }
14    }
15}