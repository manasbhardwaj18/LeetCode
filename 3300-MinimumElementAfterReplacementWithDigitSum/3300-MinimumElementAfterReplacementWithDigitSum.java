// Last updated: 5/29/2026, 10:25:08 AM
1class Solution {
2    public int minElement(int[] nums) {
3        int min = Integer.MAX_VALUE;
4
5        for(int num : nums){
6            int sum = 0;
7            while(num > 0){
8                sum += num % 10;
9                num /= 10;
10            }
11            min = Math.min(min, sum);
12        }
13        return min;
14    }
15}