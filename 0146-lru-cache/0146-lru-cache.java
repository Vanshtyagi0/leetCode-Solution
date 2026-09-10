class LRUCache {

    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;

    private Node head;
    private Node tail;

    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.isEmpty() || !map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);

        remove(node);
        addFirst(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);

            node.value = value;
            
            remove(node);
            addFirst(node);
            return;
        }

        Node newNode = new Node(key, value);

        addFirst(newNode);
        map.put(key, newNode);

        if(map.size() > capacity){
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }
    }

    private void addFirst(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */