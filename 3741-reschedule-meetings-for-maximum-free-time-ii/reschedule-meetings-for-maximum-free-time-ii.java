class Solution 
{
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) 
    {
        int n = startTime.length;

        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) 
        {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> gaps = new ArrayList<>();
        gaps.add(intervals[0][0]); 
        for (int i = 1; i < n; i++) 
        {
            gaps.add(intervals[i][0] - intervals[i - 1][1]); 
        }
        gaps.add(eventTime - intervals[n - 1][1]); 

        int[] maxBefore = new int[n + 2];
        int[] maxAfter = new int[n + 2];
        for (int i = 1; i <= n; i++) 
        {
            maxBefore[i] = Math.max(maxBefore[i - 1], gaps.get(i - 1));
        }
        
        for (int i = n; i >= 1; i--) 
        {
            maxAfter[i] = Math.max(maxAfter[i + 1], gaps.get(i));
        }

        int maxFree = 0;
        for (int i = 0; i < n; i++) 
        {
            int duration = intervals[i][1] - intervals[i][0];
            int leftGap = gaps.get(i);
            int rightGap = gaps.get(i + 1);
            int combinedGap = leftGap + rightGap;

            int bestGap = Math.max(
                i > 0 ? maxBefore[i] : 0,
                i < n - 1 ? maxAfter[i + 2] : 0
            );

            if (duration <= bestGap) 
            {
                maxFree = Math.max(maxFree, combinedGap + duration);
            } 
            else 
            {
                maxFree = Math.max(maxFree, combinedGap);
            }
        }

        for (int gap : gaps) 
        {
            maxFree = Math.max(maxFree, gap);
        }
        return maxFree;
    }
}