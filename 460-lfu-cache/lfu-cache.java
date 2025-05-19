class LFUCache {
    Map<Integer,Integer> mp;
    
    Map<Integer,int[]> hp;
    TreeSet<int[]> tp;
    int cap;
    int ts; 

    public LFUCache(int capacity) {
        cap = capacity;
        ts = 0;
        mp = new HashMap<>();
        hp = new HashMap<>();
        tp = new TreeSet<>((t1,t2) -> t1[1] != t2[1] ? t1[1] - t2[1] : t1[2] - t2[2]);
    }

    private void add(int key){
        int[] tpl = hp.get(key);
        if(tpl == null){
            int[] t = new int[]{key,1,ts};
            hp.put(key,t);
            tp.add(t);
            ts++;
            return;
        }
        tp.remove(tpl);
        int[] t = new int[]{key,tpl[1] + 1,ts};
        hp.put(key,t);
        tp.add(t);
        ts++;
    }
    
    public int get(int key) {
        var v = mp.get(key);
        if(v == null) return -1;
        add(key);
        return v;
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        if(mp.size() == cap && !mp.containsKey(key)){
            int[] tpl = tp.pollFirst();
            mp.remove(tpl[0]);
            hp.remove(tpl[0]);
        }
        mp.put(key,value);
        add(key);
    }
}