// Last updated: 2/12/2026, 6:28:31 PM
1class Solution {
2    public int longestBalanced(String s) {
3        int n = s.length();
4        int res = 0;
5        int[] freq = new int[26];
6
7        for(int i=0; i<n; i++){
8            Arrays.fill(freq, 0);
9            int max = 0, dist = 0;
10            for(int j=i;j<n;j++){
11                int c=s.charAt(j) - 'a';
12                if(++freq[c] == 1){
13                    dist++;
14                }
15                max = Math.max(max, freq[c]);
16                if(max * dist == j-i+1){
17                    res = Math.max(res, j-i+1);
18                }
19            }
20        }
21        return res;
22    }
23}