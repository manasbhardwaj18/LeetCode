class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Integer> map=new HashMap<>();
        int ind=0;
        for(List<String> l:equations){
            if(!map.containsKey(l.get(0))){
                map.put(l.get(0),ind++);
            }
            if(!map.containsKey(l.get(1))){
                map.put(l.get(1),ind++);
            }
        }
        List<List<String>> graph=new ArrayList<>(); 
        int n=ind;
        double[][] dist=new double[n][n];
        for(double arr[]:dist){
            Arrays.fill(arr, Double.MAX_VALUE);
        }
        ind=0;
        for(List<String> l:equations){
            int u=map.get(l.get(0));
            int v=map.get(l.get(1));
            double val=values[ind++];
            dist[u][v]=val;
            dist[v][u]=1/val;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i!=k && j!=k){
                        if(dist[i][k]!=Double.MAX_VALUE && dist[k][j]!=Double.MAX_VALUE){
                            dist[i][j]=Math.min(dist[i][j], dist[i][k]*dist[k][j]);
                        }
                    }
                }
            }
        }
        double []res=new double[queries.size()];
        ind=0;
        for(List<String> q:queries){
            if(map.containsKey(q.get(0)) && map.containsKey(q.get(1)) ){
                int u=map.get(q.get(0));
                int v=map.get(q.get(1));
                if(dist[u][v]==Double.MAX_VALUE) {
                    res[ind++]=-1.00;
                }
                else{
                    res[ind++]=dist[u][v];
                }
                
            }
            else{
                res[ind++]=-1.0;
            }
        }
        return res;
        
    }
}