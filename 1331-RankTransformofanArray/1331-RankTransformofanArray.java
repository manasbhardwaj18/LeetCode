// Last updated: 7/12/2026, 1:25:41 PM
1class Solution {
2    public int[] arrayRankTransform(int[] arr) {
3        int[] sorted = arr.clone();
4        Arrays.sort(sorted);
5
6        Map<Integer,Integer> rank = new HashMap<>();
7        int r = 1;
8        for(int x : sorted){
9            if(!rank.containsKey(x)){
10                rank.put(x, r);
11                r++;
12            }
13        }
14
15        for(int i=0; i<arr.length; i++){
16            arr[i] = rank.get(arr[i]);
17        }
18        return arr;
19    }
20}