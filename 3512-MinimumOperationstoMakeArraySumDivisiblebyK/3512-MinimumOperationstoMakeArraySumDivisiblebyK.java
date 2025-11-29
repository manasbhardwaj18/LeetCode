// Last updated: 11/29/2025, 8:41:55 PM
1class Solution {
2    public int minOperations(int[] nums, int k) {
3        int sum=0;
4        for(int i=0;i<nums.length;i++){
5            sum+=nums[i];
6        }
7        return sum % k;
8        
9    }
10}