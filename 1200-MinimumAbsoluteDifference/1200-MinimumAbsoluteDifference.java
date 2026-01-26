// Last updated: 1/26/2026, 12:39:35 PM
1class Solution {
2    public List<List<Integer>> minimumAbsDifference(int[] arr) {
3        Arrays.sort(arr);
4        int minDiff = Integer.MAX_VALUE;
5        for(int i=0; i<arr.length-1; i++){
6            minDiff = Math.min(minDiff, arr[i+1]-arr[i]);
7        }
8
9        List<List<Integer>> fin = new ArrayList<>();
10        for(int i=0;i<arr.length-1;i++){
11            if(arr[i+1]-arr[i] == minDiff){
12                fin.add(Arrays.asList(arr[i],arr[i+1]));
13            }
14        }
15        return fin;
16    }
17}