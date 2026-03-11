// Last updated: 3/11/2026, 1:11:18 PM
1class Solution {
2    public int bitwiseComplement(int n) {
3        if(n==0){
4            return 1;
5        }
6        int bits = (int)(Math.log(n) / Math.log(2)) + 1;
7        int mask = (1 << bits) - 1;
8        return n ^ mask;
9    }
10}