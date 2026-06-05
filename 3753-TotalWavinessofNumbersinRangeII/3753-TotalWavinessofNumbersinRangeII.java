// Last updated: 6/5/2026, 10:32:44 PM
1class Solution {
2    static final int[] waves = new int[570];
3
4    static{
5        int j=0;
6        for(int i=0; i<1000; i++){
7            int r = i % 10;
8            int m = (i/10) % 10;
9            int l = (i / 100) % 10;
10            if((m > Math.max(l, r)) | (m < Math.min(l, r))){
11                waves[j++] = i;
12            }
13        }
14    }
15
16    public long totalWaviness(long num1, long num2) {
17        return count(num2) - count(num1-1);
18    }
19
20    private long count(long num){
21        if(num < 100) return 0;
22        long res = 0;
23        for(int p : waves){
24            res += countWays(num, p);
25        }
26        return res;
27    }
28    private long countWays(long num, int pattern){
29        long type = pattern < 100 ? 1 : 0;
30        long cnt = 0, mult = 1;
31
32        for(int i=0; mult*100 <= num; i++){
33            long pre = num / (mult*1000);
34            long cur = (num / mult) % 1000;
35            long suf = num % mult;
36            long ways = 0;
37
38            if(cur > pattern){
39                ways = pre - type + 1;
40            }else if( cur == pattern){
41                ways = Math.max(0L, pre - type);
42                cnt += suf + 1;
43            }else{
44                ways = Math.max(0L, pre - type);
45            }
46            cnt += ways*mult;
47            mult *= 10;
48        }
49        return cnt;
50    }
51}