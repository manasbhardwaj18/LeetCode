class Solution {
    int[] parent;

    public int find (int x){
        if(parent[x] == -1) return x;
        return parent[x] = find(parent[x]); 
    }
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa != pb){
            parent[pb] = pa;
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // dsu
        parent = new int[n];
        Arrays.fill(parent, -1);

        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }

        int[] componentCost = new int[n];
        Arrays.fill(componentCost, Integer.MAX_VALUE);

        for(int[] edge : edges){
            int parent = find(edge[0]);
            componentCost[parent] &= edge[2];
        }      

        int[] ans = new int[query.length]; int i=0;
        for(int[] q: query){
            int ps = find(q[0]);
            int pe = find(q[1]);
            if(ps != pe) 
                ans[i] = -1;
            else{
                ans[i] = componentCost[ps];
            }
            i++;        
        }
        return ans;
    }
}
