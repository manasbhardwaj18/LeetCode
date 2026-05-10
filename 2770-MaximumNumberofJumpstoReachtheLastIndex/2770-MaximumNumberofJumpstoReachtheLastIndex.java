// Last updated: 5/10/2026, 10:36:15 AM
1class Solution {
2    public int maximumJumps(int[] nums, int target) {
3        int n = nums.length;
4
5        int[] dp = new int[n];     
6        Arrays.fill(dp, -1);      
7        dp[0] = 0;
8
9        for(int i=1; i<n; i++){
10            for(int j=0; j<i; j++){
11                if(Math.abs(nums[i] - nums[j]) <= target && dp[j] != -1){
12                    dp[i] = Math.max(dp[i], dp[j] + 1);
13                }
14            }
15        }
16        return dp[n-1];
17    }
18}