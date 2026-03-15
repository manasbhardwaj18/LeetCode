// Last updated: 3/15/2026, 3:42:52 PM
1class Fancy {
2    private static final int MOD = 1000000007;
3    private ArrayList<Long> val;
4    private long a,b;
5
6    public Fancy() {
7        val = new ArrayList<>();
8        a=1;
9        b=0;
10    }
11    
12    private long modPow(long x, long y, long mod){
13        long res =1;
14        x = x% mod;
15        while(y>0){
16            if(y%2 == 1){
17                res = (res  * x) % mod;
18            }
19            y =y /2;
20            x = (x*x) % mod;
21        }
22        return res;
23    }
24
25    public void append(int val) {
26        long x = (val - b + MOD) % MOD;
27        this.val.add((x*modPow(a, MOD -2, MOD)) % MOD);
28    }
29    
30    public void addAll(int inc) {
31        b = (b + inc)% MOD;
32    }
33    
34    public void multAll(int m) {
35        a = (a*m)%MOD;
36        b = (b*m)% MOD;
37        
38    }
39    
40    public int getIndex(int idx) {
41        if(idx >= val.size()) return -1;
42        return (int)((a*val.get(idx) + b) % MOD);
43    }
44}
45
46/**
47 * Your Fancy object will be instantiated and called as such:
48 * Fancy obj = new Fancy();
49 * obj.append(val);
50 * obj.addAll(inc);
51 * obj.multAll(m);
52 * int param_4 = obj.getIndex(idx);
53 */