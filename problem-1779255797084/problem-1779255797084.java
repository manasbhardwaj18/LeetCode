// Last updated: 5/20/2026, 11:13:17 AM
1class Solution {
2    public int[] findThePrefixCommonArray(int[] A, int[] B) {
3        int n = A.length, ct = 0;
4        int[] seen = new int[n+1];
5        int[] ans = new int[n];
6
7        for(int i=0; i<n; i++){
8            seen[A[i]]++;
9            if(seen[A[i]] == 2) ct++;
10            
11            seen[B[i]]++;
12            if(seen[B[i]] == 2) ct++;
13
14            ans[i] = ct;
15        }
16        return ans;
17
18    }
19}