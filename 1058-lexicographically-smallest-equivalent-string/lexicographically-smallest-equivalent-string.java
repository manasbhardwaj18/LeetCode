public class Solution {
    private int[] parent = new int[26];

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return;
        if (ra < rb) {
            parent[rb] = ra;
        } else {
            parent[ra] = rb;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); ++i) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            union(x, y);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int idx = c - 'a';
            int root = find(idx);
            sb.append((char) (root + 'a'));
        }
        return sb.toString();
    }
}