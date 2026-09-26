/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr=head;
        HashMap<Node,Node> hm=new HashMap<>();
        // hm.put(null,null);
        while(curr!=null){
            Node copy=new Node(curr.val);
            hm.put(curr,copy);
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            hm.get(curr).next=hm.get(curr.next);
            hm.get(curr).random=hm.get(curr.random);
            curr=curr.next;  
        }
        return hm.get(head);
    }
}
