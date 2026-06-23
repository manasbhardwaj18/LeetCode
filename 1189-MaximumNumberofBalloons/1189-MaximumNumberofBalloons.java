// Last updated: 6/23/2026, 2:20:23 PM
1class Solution {
2    public int maxNumberOfBalloons(String text) {
3       int b = 0, a= 0, l = 0, o = 0, n = 0;
4
5       for(char c : text.toCharArray()){
6        if(c == 'b') b++;
7        else if(c == 'a') a++;
8        else if(c == 'l') l++;
9        else if(c == 'o') o++;
10        else if(c == 'n') n++;
11       }
12
13       return Math.min(Math.min(b,a), Math.min(Math.min(l/2, o/2),n)); 
14    }
15}