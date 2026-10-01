class LRUCache {
    private class ListNode{
        int key,val;
        ListNode next,prev;
        ListNode(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    private final int capacity;
    private final HashMap<Integer,ListNode> map;
    private final ListNode head,tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();

        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next=tail;
        tail.prev=head;
    }

    private void remove(ListNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void moveToFront(ListNode node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        ListNode node=map.get(key);
        remove(node);
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node=map.get(key);
            node.val=value;
            remove(node);
            moveToFront(node);
            return;
        }
        if(map.size()==capacity){
            ListNode lru=tail.prev;
            map.remove(lru.key);
            remove(lru);
            moveToFront(lru);
            lru.key=key;
            lru.val=value;
            map.put(key,lru);
        }else{
            ListNode newNode=new ListNode(key,value);
            moveToFront(newNode);
            map.put(key,newNode);
        }
    }
}
