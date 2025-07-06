class FindSumPairs {
    int[] n1, n2;
    Map<Integer, Integer> freq;

    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        freq = new HashMap<>();
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int old = n2[index];
        freq.put(old, freq.get(old) - 1);
        n2[index] += val;
        freq.put(n2[index], freq.getOrDefault(n2[index], 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int x : n1) {
            res += freq.getOrDefault(tot - x, 0);
        }
        return res;
    }
}