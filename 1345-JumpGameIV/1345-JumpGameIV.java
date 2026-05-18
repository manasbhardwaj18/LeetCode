// Last updated: 5/18/2026, 1:20:02 PM
1class Solution {
2    public int minJumps(int[] arr) {
3        int n = arr.length;
4        if( n == 1) return 0;
5
6        Map<Integer, List<Integer>> ml = new HashMap<>();
7        for(int i=0; i < n; i++){
8            ml.computeIfAbsent(arr[i], k->new ArrayList<>()).add(i);
9        } 
10
11        Queue<int[]> q = new LinkedList<>();
12        q.offer(new int[]{0,0});
13
14        boolean vis[] = new boolean[n];
15        vis[0] = true;
16
17        while(!q.isEmpty()){
18            int[] current = q.poll();
19            int node = current[0];
20            int dist = current[1];
21
22            if(node == n-1) return dist;
23
24            if(node - 1 >= 0 && !vis[node-1]){
25                vis[node-1] = true;
26                q.offer(new int[]{node-1, dist+1});
27            }
28            if(node + 1 < n && !vis[node+1]){
29                vis[node+1] = true;
30                q.offer(new int[]{node+1,dist+1});
31            }
32
33            for(int next : ml.get(arr[node])){
34                if(!vis[next]){
35                    vis[next] = true;
36                    q.offer(new int[]{next, dist+1});
37                }
38            }
39            ml.get(arr[node]).clear();
40        }
41        return -1;
42    }
43}