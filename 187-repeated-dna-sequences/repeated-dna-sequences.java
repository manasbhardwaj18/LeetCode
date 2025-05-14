class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (map.containsKey(substring)) {
                if (map.get(substring) == 1) {
                    result.add(substring);
                }
                map.put(substring, map.get(substring)+1 );
            } else {
                map.put(substring, 1);
            }
        }
        
        return result;
    }
}