class MyCalendarThree {
    TreeMap<Integer, Integer> tm;
    public MyCalendarThree() {
        tm = new TreeMap<>();
    }
    public int book(int start, int end) {
        tm.put(start, tm.getOrDefault(start, 0)+1);
        tm.put(end, tm.getOrDefault(end, 0)-1);
        int max = 0, count = 0;
        for(int val: tm.values()){
            max = Math.max(max, count += val);
        }
        return max;
    }
}