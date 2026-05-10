// Last updated: 5/10/2026, 11:34:20 AM
1class Solution {
2    public int jump(int[] nums) {
3        int near = 0, far = 0, jumps = 0;
4
5        while(far < nums.length - 1){
6            int farthest = 0;
7            for(int i = near; i <= far; i++){
8                farthest = Math.max(farthest, i + nums[i]);
9            }
10            near = far + 1;
11            far = farthest;
12            jumps++; 
13        }
14        return jumps;
15    }
16}