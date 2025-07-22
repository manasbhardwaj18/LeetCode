class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int result = 0, currentSum = 0, start = 0;
        Set<Integer> seen = new HashSet<>();

        for (int end = 0; end < nums.length; end++) {

            while (seen.contains(nums[end])) {
                seen.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }

            currentSum += nums[end];
            seen.add(nums[end]);

            result = Math.max(result, currentSum);
        }

        return result;
    }
}