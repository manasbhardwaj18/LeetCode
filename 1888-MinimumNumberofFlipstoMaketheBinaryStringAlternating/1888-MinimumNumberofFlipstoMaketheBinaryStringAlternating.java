// Last updated: 3/9/2026, 1:59:08 PM
1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        String t = s+s;
5
6        int ans = n;
7        int a = 0;
8
9        for(int i=0; i< 2*n; i++){
10            char exp = (i % 2 == 0) ? '0' : '1';
11            if(t.charAt(i) != exp) a++;
12
13            if(i>=n){
14                int left = i-n;
15                char expLeft = (left % 2 == 0) ? '0' : '1';
16                if(t.charAt(left) != expLeft) a--;
17            }
18
19            if(i>= n-1){
20                int b = n - a;
21                ans  = Math.min(ans, Math.min(a,b));
22            }
23        }
24        return ans; 
25    }
26}