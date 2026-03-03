// Last updated: 3/3/2026, 1:52:07 PM
1class Solution {
2    public char findKthBit(int n, int k) {
3        if(n==1){
4            return '0';
5        }
6        int len = (1 << n) - 1;
7        int mid = (len/2) + 1;
8
9        if(k == mid){ 
10            return '1';
11        }else if( k < mid) {
12            return findKthBit(n-1, k);
13        }else{
14            int mirrorK = len - k + 1;
15            char bit  = findKthBit(n-1, mirrorK);
16            return bit == '0' ? '1' : '0';
17        }
18    }
19}