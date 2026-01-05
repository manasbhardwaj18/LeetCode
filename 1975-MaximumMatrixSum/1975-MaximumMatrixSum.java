// Last updated: 1/5/2026, 5:42:15 PM
1class Solution {
2    public long maxMatrixSum(int[][] matrix) {
3        int n = matrix.length;
4        long sum = 0;
5        int neg = 0;
6        int minVal = Integer.MAX_VALUE;
7
8        for(int i=0;i<n;i++){
9            for(int j=0;j<n;j++){
10                int val = matrix[i][j];
11                sum += Math.abs(val);
12                if(val < 0){
13                    neg++;
14                }
15                minVal = Math.min(minVal, Math.abs(val));
16            }
17        }
18        if(neg % 2 ==0){
19            return sum;
20        }else{
21            return sum-2*minVal;
22        }
23    }
24}