// Last updated: 1/16/2026, 7:41:30 PM
1class Solution {
2    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
3        int[] fen = Arrays.copyOf(hFences, hFences.length + 2);
4        fen[hFences.length] = 1;
5        fen[hFences.length + 1] = m;
6
7        int[] vert = Arrays.copyOf(vFences, vFences.length + 2);
8        vert[vFences.length] = 1;
9        vert[vFences.length + 1] = n;
10
11        Arrays.sort(fen);
12        Arrays.sort(vert);
13
14        Set<Integer> set = new HashSet<>();
15
16        for(int i=0;i<fen.length ; i++){
17            for(int j=i+1 ; j<fen.length; j++){
18                set.add(fen[j] - fen[i]);
19            }
20        }
21
22        int len = -1;
23        for(int i=0;i<vert.length;i++){
24            for(int j=i+1;j<vert.length;j++){
25                if(set.contains(vert[j] - vert[i])){
26                    len = Math.max(len , vert[j] - vert[i]);
27                }
28            }
29        }
30        int x = len == -1 ? -1 : (int) ((long)len*len % 1000000007);
31        return x;
32    }
33}