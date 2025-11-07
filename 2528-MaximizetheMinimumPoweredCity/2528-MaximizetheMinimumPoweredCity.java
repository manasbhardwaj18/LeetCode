// Last updated: 11/7/2025, 5:23:55 PM
class Solution {
    public boolean possible(long max, long[] power, int r, int k) {
        int n = power.length;
        long[] extra = new long[n];
        for(int i=0;i<n;i++) {
            if(i>0)
                extra[i] += extra[i-1];
            long current = power[i] + extra[i];
            if(current<max) {
                long diff = max - current;
                if(diff > k) return false;
                k-=diff;
                extra[i] += diff;
                int ri = Math.min(n-1,i + 2*r);
                if(ri+1 < n)
                    extra[ri+1] -= diff;
            }
        }
        return true;
    }
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];
        for(int i=0;i<n;i++) {
            int le = Math.max(i-r,0);
            int ri = Math.min(i+r,n-1);
            power[le] += stations[i];
            if(ri+1 < n)
                power[ri+1] -= stations[i];
        }
        long min = power[0];
        for(int i=1;i<n;i++) {
            power[i] += power[i-1];
            min = Math.min(min,power[i]);
        }
        long low=0,high=min + k,ans=0;
        while(low<=high) {
            long mid = low + (high-low)/2;
            if(possible(mid,power, r, k)) {
                ans=mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}