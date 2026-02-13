// Last updated: 2/13/2026, 4:10:23 PM
1class Solution {
2    public int longestBalanced(String s) {
3        int n = s.length();
4        int len = 1;
5        int max = 1;
6
7        for(int i=1;i<n;i++){
8            if(s.charAt(i) == s.charAt(i-1)){
9                len++;
10                max = Math.max(max,len);
11            }else{
12                len = 1;
13            }
14        }
15        int a=0, b=0, c=0;
16        Map<String, Integer> map = new HashMap<>();
17        map.put("0,0", -1);
18        for(int i=0; i<n; i++){
19            char ch = s.charAt(i);
20            if(ch == 'a'){
21                a++;
22            }else if(ch == 'b'){
23                b++;
24            }else{
25                c++;
26            }
27
28            int difa = a-b, difb = a-c;
29            String key = difa + "," + difb;
30            if(map.containsKey(key)){
31                max = Math.max(max, i-map.get(key));
32            }else{
33                map.put(key,i);
34            }
35        }
36        max = Math.max(max, solve(s, 'a', 'b', 'c'));
37        max = Math.max(max, solve(s, 'a', 'c', 'b'));
38        max = Math.max(max, solve(s, 'b', 'c', 'a'));
39
40        return max;
41    }
42
43    int solve(String s, char c1, char c2, char skip){
44        int maxLen = 0; 
45        int n = s.length();
46
47        for(int i=0; i<s.length();i++){
48            while(i<n && s.charAt(i) == skip) i++;
49            if(i >= n) break;
50            int p = i;
51            while(i<n && s.charAt(i) != skip) i++;
52            int q = i-1;
53            int x = 0;
54            int y = 0;
55
56            Map<Integer,Integer> map = new HashMap<>();
57            map.put(0, p-1);
58            for(int j=p; j<=q ; j++){
59                char ch = s.charAt(j);
60                if( ch == c1){
61                    x++;
62                }else if(ch == c2){
63                    y++;
64                }
65                int key = x-y;
66                if(map.containsKey(key)){
67                    maxLen = Math.max(maxLen, j-map.get(key));
68                }else{
69                    map.put(key, j);
70                }
71            }    
72        }
73        return maxLen;
74    }
75}