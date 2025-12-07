// Last updated: 12/7/2025, 2:22:18 PM
1class Solution {
2    public int countOdds(int low, int high) {
3        int num = high - low + 1;
4        if((low%2 != 0) && (high%2!=0)){
5            return num/2 +1;
6        }else{
7            return num/2;
8        }
9    }
10}