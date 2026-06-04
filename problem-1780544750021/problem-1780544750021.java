// Last updated: 6/4/2026, 9:15:50 AM
1class Solution {
2    int waviness(int m){
3        String s = Integer.toString(m);
4        int count = 0;
5
6        for(int i=1; i<s.length()-1 ; i++){
7            char current = s.charAt(i);
8
9            if((current > s.charAt(i-1) && current > s.charAt(i+1)) || 
10               (current < s.charAt(i-1) && current < s.charAt(i+1))) {
11                count++;
12               } 
13        }
14        return count;
15    }
16    public int totalWaviness(int num1, int num2) {
17        int ans = 0;
18        for(int m = num1; m <= num2; m++){
19            ans += waviness(m);
20        }
21        return ans;
22    }
23}