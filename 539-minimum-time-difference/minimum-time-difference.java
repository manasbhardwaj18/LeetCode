class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String t : timePoints) {
            String[] hm = t.split(":");
            int mins = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            minutes.add(mins);
        }
        Collections.sort(minutes);
        int minDiff = 1440 + minutes.get(0) - minutes.get(minutes.size() - 1); 
        for (int i = 1; i < minutes.size(); ++i) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }
        return minDiff;
    }
}