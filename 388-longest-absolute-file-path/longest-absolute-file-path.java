class Solution {
    public int lengthLongestPath(String input) {
        int longest = 0;
        Map<Integer, Integer> pathMap = new HashMap<>();
        pathMap.put(0, 0);

        String[] lines = input.split("\n");

        for (String line : lines) {
            String name = line.replaceAll("\t", "");
            int depth = line.length() - name.length();

            if (name.contains(".")) {
                longest = Math.max(longest, pathMap.get(depth) + name.length());
            } else {
                pathMap.put(depth + 1, pathMap.get(depth) + name.length() + 1);
            }
        }

        return longest;
    }
}