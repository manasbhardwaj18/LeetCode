class Solution {
    int search(int[] nextDay, int day) {
        if (nextDay[day] != day) {
            nextDay[day] = search(nextDay, nextDay[day]);
        }
        return nextDay[day];
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int[] nextDay = new int[events[events.length - 1][1] + 2];
        for (int d = 0; d < nextDay.length; d++) {
            nextDay[d] = d;
        }

        int count = 0;
        for (int[] evt : events) {
            int start = evt[0];
            int end = evt[1];
            int day = search(nextDay, start);
            if (day <= end) {
                count++;
                nextDay[day] = search(nextDay, day + 1);
            }
        }

        return count;
    }

}