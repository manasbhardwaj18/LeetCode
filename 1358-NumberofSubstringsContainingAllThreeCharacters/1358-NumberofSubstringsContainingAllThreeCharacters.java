// Last updated: 6/30/2026, 12:36:40 PM
1class Solution {
2    public int numberOfSubstrings(String s) {
3        char[] ch = s.toCharArray();
4        int[] abc = new int[3];
5        for(int i = 0; i < abc.length; i++){
6            abc[i] = -1;
7        }
8        int count = 0, right = 0;
9        while(right < ch.length){
10            abc[ch[right] - 'a'] = right;
11            int minIndex = Integer.MAX_VALUE;
12            for(int i = 0; i < 3; i++){
13                minIndex = Math.min(minIndex, abc[i]);
14            }
15            count += (minIndex + 1);
16            right++;
17        }
18        return count;
19    }
20}