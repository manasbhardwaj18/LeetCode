class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int ans = 0, end = 0;
        for (int[] m : meetings) {
            if (m[0] > end + 1) ans += m[0] - end - 1;
            end = Math.max(end, m[1]);
        }
        if (end < days) ans += days - end;
        return ans;
    }
}