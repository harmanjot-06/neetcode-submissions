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

        if(head==null)return null;
        
        Node newHead = null;

        HashMap<Node, Integer> ogmap = new HashMap<>();
        HashMap<Integer, Node> newmap = new HashMap<>();
        Node curr = head;
        int index = 0;

        while(curr!=null){
            ogmap.put(curr, index);
            curr = curr.next;
            index++;
        }
        curr = head;
        int newindex = 1;
        newHead = new Node(curr.val);
        newmap.put(0, newHead);
        Node newCurr = newHead;
        curr = curr.next;

        while(curr!=null){
            newCurr.next = new Node(curr.val);
            newCurr = newCurr.next;
            newmap.put(newindex, newCurr);
            newindex++;
            curr = curr.next;
        }
        newCurr.next = null;

        curr = head;
        int currindex = 0;
        newCurr = newHead;

        while(curr!=null){

            if(curr.random==null){
                newCurr.random = null;
            }
            else{
                int tempindex = ogmap.get(curr.random);
                Node temp = newmap.get(tempindex);
                newCurr.random = temp;
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}
