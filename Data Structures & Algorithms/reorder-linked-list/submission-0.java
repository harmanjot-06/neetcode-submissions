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

    public ListNode reverse(ListNode head){
        
        if(head==null)return null;
        if(head.next==null)return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
        }
        return prev;
    }

    public void reorderList(ListNode head) {
         

        if(head==null || head.next==null)return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = null;

        ListNode fpart = null;
        ListNode spart = null;
        ListNode temp = slow;

        while(fast!=null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(fast==null){
                fpart = head;
                spart = slow;
                temp.next = null;
                break;
            }
            else if(fast.next==null){
                fpart = head;
                spart = slow.next;
                slow.next = null;
                break;
            }
        }

        spart = reverse(spart);

        ListNode tempf = fpart.next;
        ListNode temps = spart.next;

        while(spart!=null){
            fpart.next=spart;
            spart.next = tempf;
            fpart = tempf;
            spart = temps;
            if(tempf!=null){
                tempf = tempf.next;
            }
            if(temps!=null)temps = temps.next;
        }


    }
}
