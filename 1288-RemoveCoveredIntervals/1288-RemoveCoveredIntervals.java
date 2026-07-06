// Last updated: 7/6/2026, 12:09:08 PM
1class Solution {
2    public int removeCoveredIntervals(int[][] intervals) {
3        Arrays.sort(intervals, (a,b) ->
4            a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
5        );
6        int count = 0;
7        int end = 0;
8
9        for(int[] interval : intervals){
10            if(interval[1] > end){
11                count++;
12                end = interval[1];
13            }
14        }
15        return count;
16    }
17}