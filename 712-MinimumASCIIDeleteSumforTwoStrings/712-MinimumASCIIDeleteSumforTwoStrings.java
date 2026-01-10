// Last updated: 1/10/2026, 3:20:39 PM
1class Solution {
2    public int minimumDeleteSum(String s1, String s2) {
3        int n = s1.length(), m = s2.length();
4        int[][] arr = new int[n+1][m+1];
5
6        for(int i=0; i<n; i++){
7            for(int j=0; j<m; j++){
8                if(s1.charAt(i) == s2.charAt(j)){
9                    arr[i+1][j+1] = arr[i][j] + s1.charAt(i);
10                }else{
11                    arr[i+1][j+1] = Math.max(arr[i][j+1] , arr[i+1][j]);
12                }
13            }
14        }
15        int res = 0;
16        for( char z : s1.toCharArray()){
17            res += z;
18        }
19        for(char y : s2.toCharArray()){
20            res += y;
21        }
22
23        return res - 2*arr[n][m];
24    }
25}