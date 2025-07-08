class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
            if (max == i) {
                ans++;
            }
        }
        return ans;
    }
}