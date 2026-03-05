// Last updated: 3/5/2026, 6:51:43 PM
1class Solution {
2    public int minOperations(String s) {
3        int odd = 0, even = 0;
4        if(s.length() == 1){
5            return 0;
6        }
7        for(int i=0; i<s.length(); i++){
8            char ch = s.charAt(i);
9            if(i%2 == 0){
10                if(ch == '0'){
11                    odd++;
12                }
13            }else{
14                if(ch == '1'){
15                    odd++;
16                }
17            }
18        }
19
20        for(int i=0; i<s.length(); i++){
21            char ch = s.charAt(i);
22            if(i%2 == 1){
23                if(ch == '0'){
24                    even++;
25                }
26            }else{
27                if(ch == '1'){
28                    even++;
29                }
30            }
31        }
32
33        return Math.min(even, odd);
34    }
35}