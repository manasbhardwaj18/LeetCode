// Last updated: 3/1/2026, 1:25:40 PM
1class Solution {
2    public int minPartitions(String n) {
3        int max = 0;
4        int size = n.length();
5        if(size == 1) return n.charAt(0)-'0';
6
7        for(int i=1; i<size; i++){
8            char ch = n.charAt(i);
9            if(max  < ch - '0'){
10                max = ch-'0';
11            }
12        }
13        if(max < n.charAt(0) - '0'){
14            return n.charAt(0)-'0';
15        }
16        return max;
17    }
18}