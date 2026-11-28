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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode rev=null;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;
        while(fast!=null){
            ListNode temp=fast.next;
            fast.next=rev;
            rev=fast;
            fast=temp;
        }
        fast=head;
        while(rev!=null){
            ListNode temp=fast.next;
            fast.next=rev;
            fast=rev;
            rev=temp;
        }
    }
}
