// Last updated: 12/27/2025, 7:36:22 AM
1import java.util.*;
2
3class Solution {
4    public int mostBooked(int n, int[][] meetings) {
5        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
6
7        PriorityQueue<Integer> free = new PriorityQueue<>();
8        for (int i = 0; i < n; ++i) free.offer(i);
9
10        PriorityQueue<long[]> busy =
11            new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1])
12                                                        : Long.compare(a[0], b[0]));
13
14        int[] cnt = new int[n];
15
16        for (int[] m : meetings) {
17            long start = m[0], end = m[1];
18
19            while (!busy.isEmpty() && busy.peek()[0] <= start)
20                free.offer((int) busy.poll()[1]);
21
22            int room;
23            long newEnd;
24            if (!free.isEmpty()) {
25                room = free.poll();
26                newEnd = end;
27            } else {
28                long[] e = busy.poll();
29                room = (int) e[1];
30                newEnd = e[0] + (end - start);
31            }
32            busy.offer(new long[] {newEnd, room});
33            cnt[room]++;
34        }
35
36        int best = 0;
37        for (int i = 1; i < n; ++i)
38            if (cnt[i] > cnt[best]) best = i;
39        return best;
40    }
41}