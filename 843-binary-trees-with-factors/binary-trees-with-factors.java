class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> subtreeCount = new HashMap<>();

        for (int root : arr) {
            subtreeCount.put(root, 1L);

            for (int factor : arr) {
                if (factor >= root) {
                    break;
                }

                if (root % factor == 0 && subtreeCount.containsKey(root / factor)) {
                    subtreeCount.put(root, (subtreeCount.get(root) + subtreeCount.get(factor) * subtreeCount.get(root / factor)));
                }
            }
        }

        long totalTrees = 0L;
        for (int key : subtreeCount.keySet()) {
            totalTrees = (totalTrees + subtreeCount.get(key)) % 1_000_000_007;
        }

        return (int) totalTrees;       
    }
}