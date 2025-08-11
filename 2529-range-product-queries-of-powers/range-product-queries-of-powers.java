class Solution {
    private int mod= 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
        
        int[]ans=new int[queries.length];
        ArrayList<Integer>prefix=new ArrayList<>();
        int t=n;
        for(int i=30;i>=0;--i)
        {
            if(t>=(1<<i))
            {
                t-=(1<<i);
                prefix.add(0,(1<<i));
            }
        }
        
         System.out.println(prefix);
        for(int i=0;i<queries.length;++i)
        {
            long  temp=1;
            for(int j=queries[i][0];j<=queries[i][1];++j)
            {
                temp=(temp*prefix.get(j))%mod;
            }
            ans[i]=(int)temp;
        }
       return ans;
    }
}