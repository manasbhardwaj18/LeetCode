// Last updated: 2/26/2026, 12:56:05 PM
1class Solution {
2    public int numSteps(String s) {
3        int carry = 0;
4        int cnt = 0;
5
6        for(int i= s.length()-1; i > 0; i--){
7            int bit = (s.charAt(i) - '0') + carry;
8            if(bit == 1){
9                cnt += 2;
10                carry = 1;
11            }else{
12                cnt += 1;
13            }
14        }
15        return cnt+carry;
16    }
17}