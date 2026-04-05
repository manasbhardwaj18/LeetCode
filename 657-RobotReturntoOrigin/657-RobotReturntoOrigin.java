// Last updated: 4/5/2026, 11:33:38 AM
1class Solution {
2    public boolean judgeCircle(String move) {
3        int l=0, r=0, u=0, d=0;
4        
5        for(int i=0;i<move.length();i++){
6            if(move.charAt(i)=='L')
7               l++;
8            else if(move.charAt(i)=='R')
9               r++;  
10            else if(move.charAt(i)=='U')
11               u++; 
12            else
13               d++;
14        }
15        if(u==d&&l==r)
16           return true;
17        return false;
18    }
19}