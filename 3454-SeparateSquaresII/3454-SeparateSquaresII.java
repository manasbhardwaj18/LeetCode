// Last updated: 1/15/2026, 1:56:35 PM
1class Solution {
2    static class Event{
3        double y, x1, x2;
4        int type;
5        Event(double y, double x1, double x2, int type){
6            this.y = y;
7            this.x1 = x1;
8            this.x2 = x2;
9            this.type = type;
10        }
11    }
12    double[] one, two;
13    int[] count;
14
15    void update(int node, int l, int r, int ql, int qr, int val){
16        if (qr <= l || r <= ql){ 
17            return;
18        }
19        if (ql <= l && r <= qr){ 
20            count[node] += val;
21        }else {
22            int m = (l + r) / 2;
23            update(node*2, l, m, ql, qr, val);
24            update(node*2+1, m, r, ql, qr, val);
25        }
26        if (count[node] > 0) {
27            two[node] = one[r] - one[l];
28        }else if (r - l == 1) {
29            two[node] = 0;
30        }else {
31            two[node] = two[node*2] + two[node*2+1];
32        }
33    }
34    public double separateSquares(int[][] squares) {
35        ArrayList<Double> list = new ArrayList<>();
36        for(int[] s:squares){
37            list.add((double)s[0]);
38            list.add(s[0]+s[2]*1.0);
39        }
40        one = list.stream().distinct().sorted().mapToDouble(d -> d).toArray();
41
42        ArrayList<Event> events = new ArrayList<>();
43        for(int[] s:squares){
44            events.add(new Event(s[1],s[0],s[0]+s[2], 1));
45            events.add(new Event(s[1]+s[2], s[0], s[0]+s[2],-1));
46        }
47        events.sort((a,b) -> Double.compare(a.y, b.y));
48
49        int n = one.length;
50        count = new int[4*n];
51        two = new double[4*n];
52
53        double total = 0, prev = events.get(0).y;
54        ArrayList<double[]> len = new ArrayList<>();
55
56        for(Event e : events){
57            if(e.y > prev){
58                double h = e.y - prev;
59                double w = two[1];
60                total += w*h;
61                len.add(new double[] {prev, h, w});
62                prev = e.y;
63            }
64            int l = Arrays.binarySearch(one, e.x1);
65            int r = Arrays.binarySearch(one, e.x2);
66            update(1, 0, n-1, l, r, e.type);
67        }
68
69        double half = total/2, act =0;
70        for(double[] s : len){
71            if(act + s[1]*s[2] >= half){
72                return s[0]+(half-act)/s[2];
73            }
74            act += s[1] * s[2];
75        }
76    return 0;
77    }
78}