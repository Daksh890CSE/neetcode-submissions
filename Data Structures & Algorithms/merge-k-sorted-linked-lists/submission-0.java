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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        for(int i=1;i<lists.length;i++){
            lists[i]=mergeTwoLists(lists[i],lists[i-1]);
        }
        return lists[lists.length-1];
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                tail.next=list1;
                list1=list1.next;
            }else{
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
        }
        tail.next=(list1!=null)?list1:list2;
        list1=dummy.next;
        return list1;
    }
}