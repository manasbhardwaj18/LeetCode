// Last updated: 1/24/2026, 1:23:46 PM
1class Solution {
2    public int minPairSum(int[] nums) {
3        Arrays.sort(nums);
4        int st =  0, ed = nums.length-1;
5        int max = 0;
6
7        while(st < ed){
8            int pSum = nums[st] + nums[ed];
9            if(pSum > max){
10                max = pSum;
11            }
12            st++;
13            ed--;
14        }
15        return max;
16    }
17}