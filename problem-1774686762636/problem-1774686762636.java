// Last updated: 3/28/2026, 2:02:42 PM
1class Solution {
2    void compute(String word, int[][] dp){
3        int n = word.length();
4        for(int i=n-1; i>=0; i--){
5            for(int j=n-1; j>=0; j--){
6                if(word.charAt(i) == word.charAt(j)){
7                    if(i+1<n && j+1 < n)
8                        dp[i][j] = 1 + dp[i+1][j+1];
9                    else
10                        dp[i][j] = 1;
11                }
12                else{
13                    dp[i][j] = 0;
14                }
15            }
16        }
17    }
18
19    public String findTheString(int[][] lcp) {
20        int n = lcp.length;
21        for(int i=0;i<n; i++){
22            if(lcp[i][i] != n-i) return "";
23        }
24        char[] word = new char[n];
25        for(int i=0; i<n; i++) word[i] = '?';
26
27        char c = 'a';
28
29        for(int i=0; i<n; i++){
30            if(word[i] == '?'){
31                if(c > 'z') return "";
32                word[i] = c;
33                for(int j=i+1; j<n; j++){
34                    if(lcp[i][j] > 0){
35                        word[j] = c;
36                    }
37                }
38                c++;
39            }
40        }
41        int[][] dp = new int[n][n];
42        compute(new String(word), dp);
43
44        if(java.util.Arrays.deepEquals(dp,lcp)){
45            return new String(word);
46        }
47        return "";
48    }
49}