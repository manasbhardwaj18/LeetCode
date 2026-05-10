// Last updated: 5/10/2026, 11:27:05 AM
1class Solution {
2    public int hIndex(int[] citations) {
3        int n = citations.length;
4        Arrays.sort(citations);
5
6        for(int i=0; i<n; i++){
7            if(citations[i] >= n-i){
8                return n-i;
9            }
10        }
11        return 0;
12    }
13}