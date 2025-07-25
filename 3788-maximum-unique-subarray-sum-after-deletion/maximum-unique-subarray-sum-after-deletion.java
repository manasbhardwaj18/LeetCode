class Solution {
    public int maxSum(int[] nums) {

        int mn = Integer.MIN_VALUE;
        boolean pos = false;
        for (int val : nums) {
            if (val > 0) {
                pos = true;
                break;
            }
            mn = Math.max(mn, val);
        }

        if (!pos) {
            return mn;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int val : nums) {
            if (val >= 0) {
                if (!set.contains(val)) {
                    if (val >= 0) {
                        sum += val;
                    }
                }

                set.add(val);
            }
        }

        return sum;
    }
}