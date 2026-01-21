// Last updated: 1/21/2026, 1:27:15 PM
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
		int n = nums.size();
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = findMinOr(nums.get(i));
		}
		return ans;
	}

	private int findMinOr(int num) {
		if (num == 2)
			return -1;
		int i = 0;
		while ((num & (1 << i)) != 0) {
			i++;
		}
		return num ^ (1 << (i - 1));
	}
}