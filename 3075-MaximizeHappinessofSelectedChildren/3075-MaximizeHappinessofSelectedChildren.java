// Last updated: 12/25/2025, 2:09:48 PM
1class Solution {
2    public long maximumHappinessSum(int[] happiness, int k) {
3        Arrays.sort(happiness);
4        long res = 0;
5        int n = happiness.length - 1;
6        for(int i=0; i <k; i++){
7            int val = happiness[n-i] - i;
8            if(val > 0){
9                res += val;
10            }else{
11                break;
12            }
13        }
14        return res;
15    }
16}