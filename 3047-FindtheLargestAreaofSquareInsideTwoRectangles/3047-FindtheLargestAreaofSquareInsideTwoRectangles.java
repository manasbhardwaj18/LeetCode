// Last updated: 1/17/2026, 12:22:31 PM
1class Solution {
2    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
3        int a = 0;
4        int b = bottomLeft.length;
5
6        for(int i=0; i<b; i++){
7            for(int j= i+1; j<b; j++){
8                int minX = Math.max(bottomLeft[i][0] , bottomLeft[j][0]);
9                int maxX = Math.min(topRight[i][0] , topRight[j][0]);
10                int minY = Math.max(bottomLeft[i][1] , bottomLeft[j][1]);
11                int maxY = Math.min(topRight[i][1] , topRight[j][1]);
12
13                if(minX < maxX && minY < maxY){
14                    int len = Math.min(maxX - minX, maxY - minY);
15                    a = Math.max(a,len);
16                }
17
18            }
19        }
20        return (long) a*a;
21    }
22}