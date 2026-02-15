// Last updated: 2/15/2026, 2:02:28 PM
1class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder sum = new StringBuilder();
4        int carry = 0;
5        int i = a.length() - 1 , j = b.length() - 1;
6        while(i>=0 || j>=0 || carry == 1){
7            if(i>=0){
8                carry += a.charAt(i--) - '0';
9            }
10            if(j>=0){
11                carry += b.charAt(j--) - '0';
12            }
13            sum.append(carry % 2);
14            carry /= 2;
15        }
16        return sum.reverse().toString();
17    }
18}