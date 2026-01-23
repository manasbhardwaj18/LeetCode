// Last updated: 1/23/2026, 2:51:24 PM
1class Solution {
2    private long flipped;
3    private int[] left, right;
4    private TreeSet<long[]> pairSum;
5
6    public int minimumPairRemoval(int[] nums) {
7        int n = nums.length;
8        if(n < 2){
9            return 0;
10        }
11
12        long[] arr = new long[n];
13        for(int i=0;i<n;i++){
14            arr[i] = nums[i];
15        }
16
17        flipped=0;
18        left = new int[n];
19        right = new int[n];
20
21        pairSum = new TreeSet<>((a,b) ->{
22            if(a[0] != b[0])
23                return Long.compare(a[0],b[0]);
24            return Long.compare(a[1],b[1]);
25        });
26
27        for(int i=0; i<n;i++){
28            left[i] = i-1;
29            right[i] = i+1;
30        }
31        for(int i=0;i<n-1;i++){
32            if(arr[i] > arr[i+1]){
33                flipped++;
34            }
35            pairSum.add(new long[] {arr[i] + arr[i+1], i});
36        }
37
38        int op=0;
39        while(flipped > 0 && !pairSum.isEmpty()){
40            long[] first = pairSum.pollFirst();
41            int i=(int) first[1];
42
43            int j=right[i];
44            int h = left[i];
45            int k = right[j];
46
47            remove(h,n,arr);
48            if(arr[i] > arr[j]){
49                flipped--;
50            }
51            remove(j,n,arr);
52            arr[i] += arr[j];
53
54            op++;
55            right[i] = k;
56            if(k<n){
57                left[k] = i;
58            }
59            add(h,n,arr);
60            add(i,n,arr);
61        }
62        return op;
63    }
64    void add(int i, int n, long[] arr){
65        if(i>=0 && i<n){
66            int j = right[i];
67            if(j<n){
68                pairSum.add(new long[] {arr[i] + arr[j],i});
69                if(arr[i] > arr[j]){
70                    flipped++;
71                }
72            }
73        }
74    }
75
76    void remove(int i, int n, long[] arr){
77        if(i>=0 && i <n){
78            int j = right[i];
79            if(j<n){
80                long[] target = new long[]{arr[i]+arr[j],i};
81                if(pairSum.contains(target)){
82                    if(arr[i] >arr[j])
83                        flipped--;
84                    pairSum.remove(target);    
85                }
86            }
87        }
88    }
89}