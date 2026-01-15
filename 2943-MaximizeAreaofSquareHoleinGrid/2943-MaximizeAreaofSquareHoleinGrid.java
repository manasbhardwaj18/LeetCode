// Last updated: 1/15/2026, 2:06:52 PM
1class Solution {
2    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
3        Arrays.sort(hBars);
4        Arrays.sort(vBars);
5        int s = Math.min(maxSpan(hBars), maxSpan(vBars));
6        return s*s;
7    }
8
9    int maxSpan(int[] bars){
10        int res = 1, streak = 1;
11        for(int i=1;i<bars.length;i++){
12            if(bars[i] - bars[i-1] == 1){
13                streak++;
14            }else{
15                streak = 1;
16            }
17            res = Math.max(res, streak);
18        }
19        return ++res;
20    }
21}