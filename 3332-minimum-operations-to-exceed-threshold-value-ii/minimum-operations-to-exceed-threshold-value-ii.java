class Solution {
    public int minOperations(int[] a, int k) {
        Arrays.sort(a);
        for (int i = 0, j = 0, count = 0, x, y; ; ++count) {
            if (i < a.length && (j >= count || a[i] <= a[j])) x = a[i++];
            else x = a[j++];
            if (x >= k) return count;
            if (i < a.length && (j >= count || a[i] <= a[j])) y = a[i++];
            else y = a[j++];
            long t = 2L * x + y; 
            a[count] = t < k ? (int) t : k;
        }
    }
}