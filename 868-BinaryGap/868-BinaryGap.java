// Last updated: 2/22/2026, 12:29:26 PM
1class Solution {
2    public int binaryGap(int n) {
3        int maxGap = 0;
4        int cur = -1;
5
6        while( n != 0){
7            if((n & 1) == 1){
8                if(cur != -1){
9                    maxGap = Math.max(maxGap, cur);
10                }
11                cur = 1;
12            }else{
13                if(cur != -1){
14                    cur++;
15                }
16            }
17            n >>= 1;
18        } 
19        return maxGap;
20    }
21}