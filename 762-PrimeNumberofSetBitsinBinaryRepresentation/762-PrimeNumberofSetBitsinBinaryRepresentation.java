// Last updated: 2/21/2026, 9:18:53 PM
1class Solution {
2    public int countPrimeSetBits(int left, int right) {
3        int[] prime = {2,3,5,7,11,13,17,19};
4        Set<Integer> primeSet = new HashSet<>();
5
6        for(int a : prime){
7            primeSet.add(a);
8        }
9
10        int res = 0;
11        for(int num = left; num <= right; num++){
12            int setBits = Integer.bitCount(num);
13
14            if(primeSet.contains(setBits)){
15                res++;
16            }
17        }
18        return res;
19    }
20}