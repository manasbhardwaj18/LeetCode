// Last updated: 5/17/2026, 10:31:38 AM
1class Solution {
2    public boolean canReach(int[] arr, int start) {
3        int n = arr.length;
4
5        boolean[] visited = new boolean[n];
6        Queue<Integer> que = new ArrayDeque<>();
7
8        que.offer(start);
9
10        while(!que.isEmpty()){
11            int i = que.poll();
12
13            if(i < 0 || i >= n || visited[i]){
14                continue;
15            }
16            if(arr[i] == 0){
17                return true;
18            }
19            visited[i] = true;
20            que.offer(i + arr[i]);
21            que.offer(i - arr[i]);
22        }
23        return false;
24
25    }
26}