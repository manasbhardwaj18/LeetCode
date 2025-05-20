class MyHashSet {
    private static final int bucket_max_size = 1000;
    private List<Integer>[] buckets;
    public MyHashSet() {
        buckets = new LinkedList[bucket_max_size];
        for(int i=0;i<bucket_max_size;i++){
            buckets[i] = new LinkedList<>();
        }
    }

    public int hash(int key){
        return key%bucket_max_size;
    }
    
    public void add(int key) {
        int bucket_index = hash(key);
        List<Integer> bucket= buckets[bucket_index];
        if(!bucket.contains(key)){
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int bucket_index = hash(key);
        List<Integer> bucket= buckets[bucket_index];
            bucket.remove((Integer)key);
    }
    
    public boolean contains(int key) {
        int bucket_index = hash(key);
        List<Integer> bucket= buckets[bucket_index];
        if(bucket.contains(key)){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */