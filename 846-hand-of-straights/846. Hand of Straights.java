class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) return false;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Stack<Integer> s = new Stack<>();
    for (int h : hand)
        pq.offer(h);
    while (!pq.isEmpty()){
        int top = pq.poll(), i = 1;
        while (i < groupSize && !pq.isEmpty()){
            int curr = pq.poll();
            if (curr == top + i)
                i++;
            else if (curr == top + i - 1)
                s.push(curr);
            else
                return false;
        }
        if (i != groupSize)
            return false;
        while (!s.isEmpty())
            pq.offer(s.pop());
    }
    return true;
}
}