class LRUCache {

    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private int size = 0;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    private void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        x.prev = x.next = null;
    }

    private void moveToFront(Node x) {
        remove(x);
        addFirst(x);
    }

    private Node removeLast() {
        Node lru = tail.prev;
        if (lru == head)
            return null;
        remove(lru);
        return lru;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }

        Node fresh = new Node(key, value);
        cache.put(key, fresh);
        addFirst(fresh);
        if (++size > capacity) {
            Node lru = removeLast();
            cache.remove(lru.key);
            size--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */