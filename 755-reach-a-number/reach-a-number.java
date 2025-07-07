class Solution {
    public int reachNumber(int target) {

        target = Math.abs(target);
        int start = 0, end = target; 
        while (start < end) {
            int mid = start + (end - start) / 2;
            long sum = ((long) mid * (mid + 1)) / 2; 
            if (sum < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int n = end;
        long sum = ((long) n * (n + 1)) / 2;
        
        while ((sum - target) % 2 != 0) {
            n++;
            sum += n;
        }
        
        return n;
    }
}