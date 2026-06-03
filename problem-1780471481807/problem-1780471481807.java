// Last updated: 6/3/2026, 12:54:41 PM
1class Solution {
2    int MAX = 10000007;
3    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
4        int l = MAX, w = MAX, minL =  MAX, minW = MAX;
5        int n = lst.length, m = wst.length;
6
7        for(int i=0; i < n; i++){
8            l =  Math.min(l, lst[i] + ld[i]);
9        }
10
11        for(int i=0; i<m; i++){
12            w = Math.min(w, wst[i]+wd[i]);
13            minL = Math.min(minL, Math.max(wst[i], l) + wd[i]);
14        }
15
16        for(int i=0; i<n; i++){
17            minW = Math.min(minW, Math.max(lst[i], w) + ld[i]);
18        }
19
20        return Math.min(minW, minL);
21    }
22}