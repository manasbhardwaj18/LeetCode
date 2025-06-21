class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        int n = freq.length;
        int ans = word.length();
        int l = 0, r = 0, curSum = 0;

        while (l < n && freq[l] == 0) l++;
        r = l;

        while (r < n) {
            while (freq[r] - freq[l] > k) {
                int range = freq[l] + k;
                int partFromOther = (n - r) * range;
                int remaining = word.length() - (curSum + partFromOther);
                ans = Math.min(ans, remaining);
                curSum -= freq[l];
                l++;
            }
            curSum += freq[r];
            r++;
        }

        int remaining = word.length() - curSum;
        ans = Math.min(ans, remaining);
        return ans;
    }
}