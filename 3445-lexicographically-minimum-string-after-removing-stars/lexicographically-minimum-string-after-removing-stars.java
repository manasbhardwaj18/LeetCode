class Solution {
    public String clearStars(String s) {
        int n = s.length();
        byte[] sc = new byte[n + 1];
        s.getBytes(0, n, sc, 0);
        sc[n] = '*';  
        int start = 0, starCount = 0;
        for (int i = 0; i < n; i++) {
            if (sc[i] == '*') {
                starCount++;
                if (starCount == ((i + 2) >> 1))
                    start = i + 1;
            }
        }
        if (starCount == 0) return s;
        if (start == n) return "";
        int[] links = new int[n];
        int[] heads = new int[128];
        for (int i = 'a'; i <= 'z'; i++)
            heads[i] = -1;

        for (int idx = start; ; idx++) {
            int c = sc[idx];
            if (c == '*') {
                if (idx >= n) break;
                sc[idx] = 0; 
                for (int i = 'a'; ; i++) {
                    if (heads[i] >= 0) {
                        sc[heads[i]] = 0; 
                        heads[i] = links[heads[i]];
                        break;
                    }
                }
            } else {
                links[idx] = heads[c];
                heads[c] = idx;
            }
        }

        int writeIdx = 0;
        for (int i = start; i < n; i++) {
            if (sc[i] != 0)
                sc[writeIdx++] = sc[i];
        }

        return new String(sc, 0, writeIdx);
    }
}