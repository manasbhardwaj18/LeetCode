// Last updated: 2/11/2026, 2:04:37 PM
1class SegmentTree{
2    public int n;
3    public int[] sum, mn, mx;
4
5    SegmentTree(int n_){
6        n = n_;
7        sum = new int[4*n];
8        mn  = new int[4*n];
9        mx  = new int[4*n];
10    }
11
12    void pull(int node){
13        int lc = node*2, rc = node*2 + 1;
14        sum[node] = sum[lc] + sum[rc];
15        mn[node]  = Math.min(mn[lc], sum[lc] + mn[rc]);
16        mx[node]  = Math.max(mx[lc], sum[lc] + mx[rc]);
17    }
18
19    void update(int idx, int val){
20        update(1, 0, n-1, idx, val);
21    }
22
23    void update(int node, int l, int r, int idx, int val){
24        if(l == r){
25            sum[node] = val;
26            mn[node]  = val;
27            mx[node]  = val;
28            return;
29        }
30        int m = (l+r)/2;
31        if(idx <= m){
32            update(node* 2, l , m, idx, val);
33        }else{
34            update(node*2+1, m+1, r, idx, val);
35        }
36        pull(node);
37    }
38
39    boolean exist(int node, int sum_before, int target){
40        int need = target - sum_before;
41        return mn[node] <= need && need <= mx[node];
42    }
43    int find_rightmost_prefix(int target){
44        return find_rightmost_prefix(1,0,n-1,0,target);
45    }
46    int find_rightmost_prefix(int node, int l, int r, int sum_before, int target){
47        if(!exist(node, sum_before, target)){
48            return -1;
49        }
50        if(l == r){
51            return l;
52        }
53
54        int m = (l+r)/2;
55        int lc = node*2, rc = node*2+1;
56
57        int sum_before_right = sum_before  + sum[lc];
58        if(exist(rc, sum_before_right, target)){
59            return find_rightmost_prefix(rc, m+1, r, sum_before_right, target);
60        }
61        return find_rightmost_prefix(lc, l ,m , sum_before, target);
62    }
63}
64class Solution {
65    public int longestBalanced(int[] nums) {
66        int n = nums.length;
67
68        SegmentTree stree = new SegmentTree(n);
69        HashMap<Integer, Integer> f1 = new HashMap<>();
70
71        int res = 0;
72        for(int l = n-1; l >=0; l--){
73            int x = nums[l];
74
75            Integer old = f1.get(x);
76            if(old != null){
77                stree.update(old, 0); 
78            }
79            f1.put(x,l);
80            stree.update(l, ((x & 1) == 0)? 1 : -1);
81
82            int r = stree.find_rightmost_prefix(0);
83            if(r >= l){
84                    res = Math.max(res, r-l+1);
85            }
86            
87        }
88        return res;
89    }
90}