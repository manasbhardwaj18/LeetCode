// Last updated: 2/28/2026, 1:28:46 PM
1class Solution {
2
3    int Div(int x, int y){
4        return (x+y-1)/y;
5    }
6    public int minOperations(String s, int k) {
7        int n = s.length();
8        int z = 0;
9
10        for(char c: s.toCharArray()){
11            if(c == '0') z++;
12        }
13        if(n==k){
14            if(z==0) return 0;
15            if(z==n) return 1;
16            return -1;
17        }
18        int res = Integer.MAX_VALUE;
19
20        if(z % 2 == 0){
21            int m = Math.max(Div(z,k), Div(z,n-k));
22            if( m % 2 == 1) m++;
23            res = Math.min(res, m);
24        }
25
26        if(z % 2 == k % 2){
27            int m = Math.max(Div(z,k), Div(n-z,n-k));
28            if(m%2 == 0) m++;
29            res = Math.min(res, m);
30        }
31        return res == Integer.MAX_VALUE ? -1 : res;
32    }
33}