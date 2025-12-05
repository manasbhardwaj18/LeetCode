// Last updated: 12/5/2025, 11:19:05 PM
1class Solution {
2    public int countPartitions(int[] nums) {
3        int total = 0;
4        for(int i=0;i<nums.length;i++){
5            total += nums[i];
6        }
7        int left = 0, count=0;
8        for(int i=0;i<nums.length-1;i++){
9            left += nums[i];
10            int right = total-left;
11            if((left%2) == (right%2)){
12                count++;
13            }
14        }
15        return count;
16    }
17}