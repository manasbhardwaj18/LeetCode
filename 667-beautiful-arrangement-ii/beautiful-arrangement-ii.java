class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        for (int i = 0, a = 1, z = k + 1; i <= k; i++)
            ans[i] = i % 2 == 1 ? z-- : a++;
        for (int i = k+1; i < n;)
            ans[i] = ++i;
        return ans;
    }
}