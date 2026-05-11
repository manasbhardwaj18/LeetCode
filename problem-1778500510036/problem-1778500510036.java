// Last updated: 5/11/2026, 5:25:10 PM
1class AllInOne<T> {
2    Map<T, Integer> map = new HashMap<T, Integer>();
3    ArrayList<T> list = new ArrayList<T>();
4    Random rand = new Random();
5
6    boolean add(T val) {
7        if (val == null || map.get(val) != null)
8            return false;
9        list.add(val);
10        map.put(val, list.size() - 1);
11        return true;
12    }
13
14    boolean remove(T val) {
15        if (val == null || map.get(val) == null)
16            return false;
17        int indexInList = map.get(val);
18        int lastValidIndex = list.size() - 1;
19        T lastValidIndexEle = list.get(lastValidIndex);
20        map.put(lastValidIndexEle, indexInList);
21        list.set(indexInList, lastValidIndexEle);
22        swap(indexInList, lastValidIndex);
23        map.remove(val);
24        list.remove(list.size() - 1); //remove the last element in O(1) time
25        return true;
26    }
27
28    T removeRandomElement() {
29        int randIndex = rand.nextInt(list.size());
30        T target = list.get(randIndex);
31        // if(remove(target)) {
32        //   return target;
33        // }
34        return target;
35    }
36
37    void swap(int index1, int index2) {
38        T temp = list.get(index1);
39        list.set(index1, list.get(index2));
40        list.set(index2, temp);
41    }
42}
43
44class RandomizedSet {
45    AllInOne<Integer> allInOne = new AllInOne<Integer>();
46
47    public RandomizedSet() {
48    }
49
50    public boolean insert(int val) {
51        return allInOne.add(val);
52    }
53
54    public boolean remove(int val) {
55        return allInOne.remove(val);
56    }
57
58    public int getRandom() {
59        return allInOne.removeRandomElement();
60    }
61}
62
63/**
64 * Your RandomizedSet object will be instantiated and called as such:
65 * RandomizedSet obj = new RandomizedSet();
66 * boolean param_1 = obj.insert(val);
67 * boolean param_2 = obj.remove(val);
68 * int param_3 = obj.getRandom();
69 */