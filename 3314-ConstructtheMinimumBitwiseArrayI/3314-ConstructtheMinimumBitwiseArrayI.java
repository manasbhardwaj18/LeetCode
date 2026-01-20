// Last updated: 1/20/2026, 12:25:51 PM
1class Solution {
2    public int[] minBitwiseArray(List<Integer> nums) {
3        int[] res = new int[nums.size()];
4        for(int i=0; i<nums.size(); i++){
5            int n = nums.get(i);
6            if(n != 2){
7                res[i] = n - ((n+1) & (-n - 1))/2;
8            }else{
9                res[i] = -1;
10            }
11        }
12        return res;
13    }
14}