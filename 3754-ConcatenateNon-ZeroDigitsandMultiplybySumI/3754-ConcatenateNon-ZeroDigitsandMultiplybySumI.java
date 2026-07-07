// Last updated: 7/7/2026, 1:00:05 PM
1class Solution {
2    public long sumAndMultiply(int n) {
3        long x = 0, sum = 0;
4        for(char c : String.valueOf(n).toCharArray()){
5            if(c != '0'){
6                x = x*10 + c - '0';
7                sum += c - '0';
8            }
9        }
10        return x * sum;
11    }
12}