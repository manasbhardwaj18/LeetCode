class Solution {
    public static int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] ins = new int[n];  
        int[] queue = new int[n];
        int[] deep = new int[n];  

        for (int i = 0; i < n; i++) {
            ins[favorite[i]]++;
        }

        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (ins[i] == 0) queue[r++] = i;  
        }

        while (l < r) {
            int cur = queue[l++];  
            int next = favorite[cur];  
            deep[next] = Math.max(deep[next], deep[cur] + 1);  
            if (--ins[next] == 0) {  
                queue[r++] = next;
            }
        }

        int smallCircle = 0;  
        int bigCircle = 0;  

        for (int i = 0; i < n; i++) {
            if (ins[i] != 0) {  
                ins[i] = 0;  
                int count = 1;  
                for (int j = favorite[i]; j != i; j = favorite[j]) {
                    count++;
                    ins[j] = 0;  
                }

                if (count == 2) {  
                    smallCircle += deep[i] + deep[favorite[i]] + 2;
                } else {  
                    bigCircle = Math.max(bigCircle, count);
                }
            }
        }

        return Math.max(bigCircle, smallCircle);  
    }
}