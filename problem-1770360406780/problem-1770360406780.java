// Last updated: 2/6/2026, 12:16:46 PM
1class Solution {
2    public int minRemoval(int[] nums, int k) {
3        Arrays.sort(nums);
4        int m=0, maxLen = 0;
5        for(int n = 0; n< nums.length; n++){
6            while( (long)nums[n] > (long)nums[m]*k){
7                m++;
8            }
9            maxLen = Math.max(maxLen, n-m+1);
10        }
11        return nums.length - maxLen;
12    }
13}