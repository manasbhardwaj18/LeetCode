// Last updated: 12/8/2025, 1:54:09 PM
1class Solution {
2    public int countTriples(int n) {
3        int res = 0;
4        for(int m=2; m*m < n; m++){
5            for(int l=1; l<m; l++){
6                if(((m-l) & 1) == 0 || gcd(m,l) != 1){
7                    continue;
8                }
9                int c = m*m + l*l;
10                if(c>n){ 
11                continue;
12                }
13                res += 2*(n/c);
14            }
15        }
16        return res; 
17    }
18    int gcd(int x, int y){
19        return y==0 ? x : gcd(y, x%y);
20    }
21}