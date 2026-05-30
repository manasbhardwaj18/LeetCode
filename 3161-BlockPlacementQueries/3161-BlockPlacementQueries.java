// Last updated: 5/30/2026, 1:22:38 PM
1class Solution {
2    class SegTree{
3        int n;
4        int[] tree;
5        public SegTree(int size){
6            n = 1;
7            while(n <= size) n*= 2;
8            tree = new int[2*n];
9        }
10
11        public void update(int i, int val){
12            for(tree[i += n] = val; i>1; i>>=1){
13                tree[i >> 1] = Math.max(tree[i], tree[i^1]);
14            }
15        }
16
17        public int query(int r){
18            int res = 0;
19            for(int l = n, r_id = r+n+1; l < r_id; l >>= 1, r_id >>= 1){
20                if((l & 1) != 0){
21                    res = Math.max(res, tree[l++]);
22                }
23                if((r_id & 1) != 0){
24                    res = Math.max(res, tree[--r_id]);
25                }
26            }
27            return res;
28        }
29    }
30    public List<Boolean> getResults(int[][] queries) {
31        int maxX = 0;
32        for(int[] q : queries){
33            maxX = Math.max(maxX, q[1]);
34        }
35
36        SegTree st = new SegTree(maxX+1);
37        TreeSet<Integer> obs = new TreeSet<>();
38        obs.add(0);
39        List<Boolean> res = new ArrayList<>();
40
41        for(int[] q : queries){
42            int x = q[1];
43            if(q[0] == 1){
44                Integer nxt = obs.ceiling(x);
45                Integer prev = obs.floor(x);
46
47                st.update(x, x-prev);
48                if(nxt != null){
49                    st.update(nxt, nxt - x);
50                }
51                obs.add(x);
52            }else{
53                int sz = q[2];
54                Integer prev = obs.floor(x);
55                int mx = Math.max(x-prev, st.query(prev));
56                res.add(sz <= mx);
57            }
58        }
59        return res;
60    }
61}