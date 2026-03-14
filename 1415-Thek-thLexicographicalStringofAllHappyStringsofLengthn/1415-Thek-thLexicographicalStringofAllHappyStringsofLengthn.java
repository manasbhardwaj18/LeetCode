// Last updated: 3/14/2026, 1:21:28 PM
1class Solution {
2    public String getHappyString(int n, int k) {
3        if(k > (3 << (n-1))){
4            return "";
5        }
6        Queue<String> que = new LinkedList<>();
7        que.add("");
8
9        while(k > 0){
10            String temp = que.poll();
11
12            for(char ch ='a'; ch <= 'c'; ch++){
13                if(temp.length() == 0 || temp.charAt(temp.length()-1) != ch){
14                    que.add(temp + ch);
15
16                    if(temp.length() + 1 == n){
17                        k--;
18                    }
19                }
20
21                if(k==0) break;
22            }
23        }
24        String res = "";
25        for(String s : que){
26            res = s;
27        }
28        return res; 
29    }
30}