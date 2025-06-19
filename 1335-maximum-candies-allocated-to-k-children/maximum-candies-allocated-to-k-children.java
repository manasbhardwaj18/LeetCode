class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 0;
        for (int c : candies) right = Math.max(right, c); 
        long total = 0;
        for (int c : candies) total += c;
        if (total < k) return 0; 
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, k, mid)) {
                result = mid;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canDistribute(int[] candies, long k, int val) {
        long count = 0; 
        for (int c : candies) {
            count += c / val;
            if (count >= k) return true;  
        }
        return false;
    }
}