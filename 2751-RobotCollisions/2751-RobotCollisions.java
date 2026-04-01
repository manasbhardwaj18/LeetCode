// Last updated: 4/1/2026, 4:00:26 PM
1class Solution {
2    public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String d) {
3        int n = pos.length;
4        Integer[] order = new Integer[n];
5        for(int i=0; i<n; i++){
6            order[i] = i;
7        }
8        Arrays.sort(order,(a,b)->pos[a]-pos[b]);
9        boolean[] alive =new boolean[n];
10        Arrays.fill(alive,true);
11
12        Deque<Integer> st = new ArrayDeque<>();
13        for(int idx : order){
14            if(d.charAt(idx) == 'R') st.push(idx);
15            else{
16                while(!st.isEmpty()){
17                    int top= st.peek();
18                    if(h[top] < h[idx]){
19                        alive[top] = false;
20                        st.pop();
21                        h[idx]--;
22                    }
23                    else if(h[top] > h[idx]){
24                        alive[idx] = false;
25                        h[top]--;
26                        break;
27                    }
28                    else{
29                        alive[top] = false;
30                        alive[idx] = false;
31                        st.pop();
32                        break;
33                    }
34                }
35            }
36        }
37        List<Integer> res = new ArrayList<>();
38        for(int i=0; i<n; i++)
39            if(alive[i]) res.add(h[i]);
40
41        return res;
42        
43    }
44}