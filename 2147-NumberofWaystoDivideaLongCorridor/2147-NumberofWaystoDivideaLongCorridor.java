// Last updated: 12/14/2025, 1:57:22 PM
1class Solution {
2    int mod = 1000000007;
3    public int numberOfWays(String corridor) {
4        int n = corridor.length(), count = 0;
5        for(int i=0;i<n;i++){
6            if(corridor.charAt(i) == 'S'){
7                count++;
8            }
9        }
10        if(count==0 || count % 2 !=0){
11            return 0;
12        }
13        count=0;
14        long ans = 1;
15        int a=0, b=0;
16        boolean flag = false;
17        while(a<n){
18            if(corridor.charAt(a)=='S'){
19                count++;
20                if(count % 2 == 0){
21                    flag = true;
22                }else if(count > 2){
23                    ans = (ans*(b+1))% mod;
24                    count = 1;
25                    flag = false;
26                    b=0;
27                }
28            }else if(flag){
29                b++;
30            }
31            a++;
32        }
33        return (int)ans;
34    }
35}