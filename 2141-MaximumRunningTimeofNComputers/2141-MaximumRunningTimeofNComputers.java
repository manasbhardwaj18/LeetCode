// Last updated: 12/1/2025, 4:47:07 PM
1class Solution {
2    public long maxRunTime(int n, int[] batteries) {
3        long sum = 0;
4        for(int b : batteries){
5            sum += b;
6        }
7        long left = 0, right = sum/n;
8        while(left<right){
9            long mid = (left + right +1) >> 1;
10            long need = mid*n, have = 0;
11
12            for(int b : batteries){
13                have += Math.min(b,mid);
14            }
15            if(have >= need){
16                left = mid;
17            }else{
18                right = mid - 1;
19            }
20        }
21        return left;
22    }
23}