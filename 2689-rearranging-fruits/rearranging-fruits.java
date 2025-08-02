class Solution {
    public long minCost(int[] b1, int[] b2) {
        Map<Integer, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        for (int x : b1) m1.put(x, m1.getOrDefault(x, 0) + 1);
        for (int x : b2) m2.put(x, m2.getOrDefault(x, 0) + 1);
        
        Set<Integer> all = new HashSet<>(m1.keySet());
        all.addAll(m2.keySet());
        
        int min = Integer.MAX_VALUE;
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        
        for (int x : all) {
            min = Math.min(min, x);
            int d = m1.getOrDefault(x, 0) - m2.getOrDefault(x, 0);
            if (d % 2 != 0) return -1;
            if (d > 0) for (int i = 0; i < d/2; i++) l1.add(x);
            else if (d < 0) for (int i = 0; i < -d/2; i++) l2.add(x);
        }
        
        Collections.sort(l1);
        Collections.sort(l2, Collections.reverseOrder());
        
        long res = 0;
        for (int i = 0; i < l1.size(); i++) 
            res += Math.min((long)Math.min(l1.get(i), l2.get(i)), 2L * min);
        
        return res;
    }
}