/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }

        ListNode curr=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode grpprev=dummy;
        while(true){
            ListNode kth=getkth(grpprev,k);
            if(kth==null){
                break;
            }

            ListNode grpstart=grpprev.next;
            ListNode grpnext=kth.next;
            kth.next=null;
            grpprev.next=reverse(grpstart);
            grpstart.next=grpnext;
            grpprev=grpstart;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;   
    }
    public ListNode getkth(ListNode head,int k){
        ListNode curr=head;
        for(int i=0;i<k;i++){
            curr=curr.next;
            if(curr==null){
                break;
            }
        }
        return curr;
    }
}
