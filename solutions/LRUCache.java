/***LRU Cache  https://leetcode.com/problems/lru-cache/  ***/

class LRUCache {
    private HashMap<Integer,Integer> map;
    private Deque<Integer> deque; 
    int capacity;
    public LRUCache(int capacity) {
        this.capacity= capacity;
        this.map = new HashMap<>(capacity);
        this.deque= new LinkedList<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int x= map.get(key);
            deque.remove(key);
            deque.addFirst(key);    
            return x;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            int x= map.get(key);
            deque.remove(key);
            deque.addFirst(key);
            map.put(key,value);
        }
        else{
            if(map.size()==capacity){
                int a =deque.pollLast();
                map.remove(a);
            }
            map.put(key,value);
            deque.addFirst(key);
            }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */