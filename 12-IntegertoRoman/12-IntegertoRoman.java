// Last updated: 5/11/2026, 5:24:51 PM
1class Solution {
2    final static int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
3    final static String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
4
5    public String intToRoman(int N) {
6        StringBuilder ans = new StringBuilder();
7        for (int i = 0; N > 0; i++)
8            while (N >= val[i]) {
9                ans.append(rom[i]);
10                N -= val[i];
11            }
12        return ans.toString();
13    }
14}