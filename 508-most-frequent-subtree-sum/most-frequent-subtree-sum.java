class Solution {
    Map<Integer, List<Integer>> freqToSums = new HashMap<>();
    Map<Integer, Integer> sumToFreq = new HashMap<>();
    int maxFreq = 0;
	
    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);
        List<Integer> list = freqToSums.get(maxFreq);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + getSum(root.left) + getSum(root.right);
        sumToFreq.put(sum, sumToFreq.getOrDefault(sum, 0) + 1);
        int newFreq = sumToFreq.get(sum);
        if (sumToFreq.get(sum) > maxFreq) {
            maxFreq = newFreq;
        }
        freqToSums.putIfAbsent(newFreq, new ArrayList<>());
        freqToSums.get(newFreq).add(sum);
        return sum;
    }
}