// Last updated: 4/4/2026, 12:32:03 PM
1class Solution {
2    public String decodeCiphertext(String en, int rows) {
3        if(en.isEmpty()) return en;
4
5        int n = en.length();
6        int col = (n + rows - 1)/ rows;
7
8        StringBuilder res = new StringBuilder();
9        
10        for(int s= 0; s<col; s++ ){
11            int a =0, b= s;
12            while(a < rows && b < col){
13                res.append(en.charAt(a*col+b));
14                a++;
15                b++;
16            }
17        }
18        
19        int i= res.length();
20        while(i > 0 && res.charAt(i-1)==' ') i--;
21        return res.substring(0,i);
22    }
23}