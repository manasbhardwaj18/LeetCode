// Last updated: 6/1/2026, 10:39:44 AM
1class Solution {
2    public int minimumCost(int[] cost) {
3        Arrays.sort(cost);
4        int res = 0;
5
6        for(int i= cost.length -1; i>=0; i-=3){
7            res += cost[i];
8            if(i-1 >= 0){
9                res += cost[i-1];
10            }
11        }
12        return res;
13    }
14}