// Last updated: 2/25/2026, 1:31:06 PM
1class Solution {
2    public int[] sortByBits(int[] arr) {
3        Integer[] arr1 = new Integer[arr.length];
4        for(int i=0;i<arr.length;i++){
5            arr1[i] = arr[i];
6        }
7        Arrays.sort(arr1, (a,b) -> {
8            int ca = Integer.bitCount(a);
9            int cb = Integer.bitCount(b);
10            if(ca == cb){
11                return a.compareTo(b);
12            }
13            return Integer.compare(ca,cb);
14        });
15
16        for(int i=0; i<arr.length; i++){
17            arr[i] = arr1[i];
18        }
19        return arr;
20    }
21}