// Last updated: 7/18/2026, 7:48:15 PM
1class Solution {
2    public int findGCD(int[] nums) {
3        int min = 1001, max = 0;
4
5        for(int num : nums){
6            if(num < min) min = num;
7            if(num > max) max = num;
8        }
9        return gcd(min, max);
10    }
11
12    private int gcd(int a, int b){
13        while(b != 0){
14            int rem = a % b;
15            a = b;
16            b = rem;
17        }
18        return a;
19    }
20}