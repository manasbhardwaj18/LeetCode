class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String st = Long.toString(start-1), fn = Long.toString(finish);

        while(st.length() != fn.length()){
            st = "0" + st;
        }

        long[][] dp = new long[fn.length()+1][2];

        for(long[] it : dp){
            Arrays.fill(it, -1);
        }

        long val = f(fn, limit, s, st.length(), 1, dp);

        for(long[] it : dp){
            Arrays.fill(it, -1);
        }

        return val - f(st, limit, s, fn.length(), 1, dp);
    }

    long f(String num, int limit, String s, int n, int tight, long[][] dp){
        if(n == 0){
            return 1;
        }

        if(dp[n][tight] != -1){
            return dp[n][tight];
        }

        long ans = 0;

        if(n <= s.length()){
            if(tight == 0){
                ans = f(num, limit, s, n-1, 0, dp);
            }
            else{
                if(s.charAt(s.length()-n) == num.charAt(num.length()-n)){
                    ans = f(num, limit, s, n-1, 1, dp);
                }
                else if(s.charAt(s.length()-n) < num.charAt(num.length()-n)){
                    ans = f(num, limit, s, n-1, 0, dp);
                }
            }
        }
        else{
            if(tight == 1){
                int nlim = num.charAt(num.length()-n)-'0';

                for(int i = 0;i <= Math.min(limit, nlim);i++){
                    if(i == nlim){
                        ans += f(num, limit, s, n-1, 1, dp);
                    }
                    else{
                        ans += f(num, limit, s, n-1, 0, dp);
                    }
                }
            }
            else{
                for(int i = 0;i <= limit;i++){
                    ans += f(num, limit, s, n-1, 0, dp);
                }
            }
        }

        return dp[n][tight] = ans;
    }
}