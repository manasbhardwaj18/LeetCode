// Last updated: 5/3/2026, 2:44:24 PM
1class Solution {
2    private int[] buildLPS(String pattern){
3        int n = pattern.length();
4        int[] lps = new int[n];
5
6        int len = 0, i = 1;
7        while(i < n){
8            if(pattern.charAt(i) == pattern.charAt(len)){
9                lps[i++] = ++len;
10            }else{
11                if(len != 0){
12                    len = lps[len - 1];
13                }else{
14                    lps[i++] = 0;
15                }
16            }
17        }
18        return lps;
19    }
20    public boolean rotateString(String s, String goal) {
21        if(s.length() != goal.length()) return false;
22
23        String text = s + s;
24        int[] lps = buildLPS(goal);
25        int i=0, j=0;
26
27        while(i < text.length()){
28            if(text.charAt(i) == goal.charAt(j)){
29                i++;
30                j++;
31            }
32            if( j == goal.length()){
33                return true;
34            }else if( i < text.length() && text.charAt(i) != goal.charAt(j)){
35                if(j!=0){
36                    j = lps[j-1];
37                }else{
38                    i++;
39                }
40            }
41        }
42        return false;
43    }
44}