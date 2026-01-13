// Last updated: 1/13/2026, 12:44:56 PM
1class Solution {
2    public double separateSquares(int[][] squares) {
3        double total = 0;
4        double low = 1e18, high = -1e18;
5        for(int[] sq : squares){
6            double y = sq[1], l = sq[2];
7            total += l*l;
8            low = Math.min(low, y);
9            high  = Math.max(high, y+l);
10        }
11
12        for(int i=0;i<80;i++){
13            double mid  = (low + high) / 2.0;
14            double halfA = 0;
15            for(int[] s : squares){
16                double y = s[1], l = s[2];
17                if(mid <= y) continue;
18                if(mid >= y+l) {
19                    halfA += l*l; 
20                }else{
21                    halfA += l*(mid-y);
22                }
23            }
24
25            if(halfA * 2 < total){
26                low = mid;
27            }else{
28                high = mid;
29            }
30        }
31        return low;
32    }
33}