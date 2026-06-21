// Last updated: 6/21/2026, 1:41:01 PM
1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        Arrays.sort(costs);
4        int res = 0;
5        for(int cost : costs){
6            if(cost > coins) break;
7            res++;
8            coins -= cost;
9        }
10        return res;
11    }
12}