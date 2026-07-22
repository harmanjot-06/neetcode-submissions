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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next==null && n==1)return null;
        

        int len = 0;
        ListNode curr = head;

        while(curr!=null){
            len+=1;
            curr = curr.next;
        }

        if(n==len)return head.next;

        ListNode prev = null;
        curr = head;

        int counter = len - n + 1;
        for(int i = 1; i<=counter; i++){
            if(i==counter-1){
                prev = curr;
            }
            curr = curr.next;
        }

        prev.next = curr;
        return head;
    }
}
