// Last updated: 2/16/2026, 1:04:20 PM
1class Solution {
2    public int reverseBits(int n) {
3        int result = 0;
4        for(int i=0; i<32 ;i++){
5            result <<= 1;
6            result |= (n&1);
7            n >>>= 1;
8        }
9        return result; 
10    }
11}