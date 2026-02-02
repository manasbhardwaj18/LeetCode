// Last updated: 2/2/2026, 12:15:50 PM
1class Solution {
2    static class Window{
3        int k;
4        TreeMap<Integer, Integer> low = new TreeMap<>();
5        TreeMap<Integer, Integer> high = new TreeMap<>();
6        long sumL = 0; 
7        int sizeL = 0, sizeH = 0;
8
9        Window(int k){
10            this.k = k;
11        }
12        int windowSize(){
13            return sizeL + sizeH;
14        }
15
16        void add(TreeMap<Integer, Integer> map, int x){
17            map.put(x, map.getOrDefault(x,0) + 1);
18        }
19        boolean remove(TreeMap<Integer, Integer> map, int x){
20            Integer c = map.get(x);
21            if(c == null) return false;
22            if(c == 1)  map.remove(x);
23            else map.put(x,c-1);
24            return true;
25        }
26
27        int popLast(TreeMap<Integer, Integer> map){
28            int x  = map.lastKey();
29            remove(map,x);
30            return x;
31        }
32        int popFirst(TreeMap<Integer, Integer> map){
33            int x = map.firstKey();
34            remove(map,x);
35            return x;
36        }
37
38        void equality(){
39            int m = Math.min(k, windowSize());
40            while(sizeL > m){
41                int x  = popLast(low);
42                sizeL--;
43                sumL-=x;
44                add(high,x);
45                sizeH++;
46            }
47            while(sizeL < m && sizeH > 0){
48                int x = popFirst(high);
49                sizeH--;
50                add(low,x);
51                sizeL++;
52                sumL += x;
53            }
54        }
55        void add1(int x){
56            if(sizeL == 0){
57                add(low,x);
58                sizeL++;
59                sumL += x;
60            }else{
61                int mxL = low.lastKey();
62                if(x <= mxL){
63                    add(low,x);
64                    sizeL++;
65                    sumL += x;
66                }else{
67                    add(high,x);
68                    sizeH++;
69                } 
70            }
71            equality();
72        }
73        void rem(int x){
74            if(remove(low,x)){
75                sizeL--;
76                sumL -= x;
77            }else if(remove(high,x)){
78                sizeH--;
79            }
80            equality();
81        }
82        
83        long query(){
84            return sumL;
85        } 
86    }
87    public long minimumCost(int[] nums, int k, int dist) {
88        int a = nums.length;
89        k -= 1;
90        Window win = new Window(k);
91        long res = Long.MAX_VALUE;
92        for(int i=1; i<= 1+dist; i++){
93            win.add1(nums[i]);
94        }
95         res = win.query();
96
97        for(int i=2; i+dist < a;i++){
98            win.rem(nums[i-1]);
99            win.add1(nums[i+dist]);
100            res = Math.min(res, win.query());
101        }
102        return res + nums[0];
103    }
104}