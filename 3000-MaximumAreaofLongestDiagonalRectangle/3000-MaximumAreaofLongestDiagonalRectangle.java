// Last updated: 12/14/2025, 1:58:15 PM
1class Solution {
2    public int areaOfMaxDiagonal(int[][] dimensions) {
3        int maxArea=0;
4        int maxDia=0;
5        int n=dimensions.length;
6        for(int i=0; i<n; i++) {
7            int l=dimensions[i][0];
8            int b=dimensions[i][1];
9
10            int currDia=l*l+b*b;
11            int currArea=l*b;
12
13            if(currDia>maxDia || (currDia==maxDia && currArea>maxArea)) {
14                maxArea=currArea;
15                maxDia=currDia;
16            }
17        }
18
19        return maxArea;
20    }
21}