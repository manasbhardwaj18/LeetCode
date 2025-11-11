// Last updated: 11/11/2025, 11:29:00 AM
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int[m+1][n+1];
        for(String str : strs){
            int z = 0 , ones = 0;
            for(char c : str.toCharArray()){
                if(c=='0'){
                    z++;
                }else{
                    ones++;
                }
            }
            for(int i = m;i>=z;i--){
                for(int j = n; j>=ones; j--){
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-z][j-ones]);
                }
            }
        }
        return dp[m][n];
    }
}