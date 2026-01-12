// Last updated: 1/12/2026, 11:48:20 AM
1class Solution {
2    public int minTimeToVisitAllPoints(int[][] points) {
3        int tot = 0;
4        for(int a=1; a<points.length;a++){
5            tot += Math.max(Math.abs(points[a][0] - points[a-1][0]), Math.abs(points[a][1] - points[a-1][1]));
6        }
7        return tot;
8    }
9}