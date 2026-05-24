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
    public ListNode reverseList(ListNode head) {
        ListNode newNode;
        ListNode next = null;
        ListNode prev = null;
        ListNode currNode = head;

        while(currNode != null) {
            next = currNode.next; //store next node

            if(currNode == head) { //if we are at the head node
                currNode.next = null; //reassign next ptr to end of list
            } else {
                currNode.next = prev; //reassign next ptr to prev node 
            }

            prev = currNode; //move previous node to current
            currNode = next; //move current node to the next node
        }

        //previous node is the new head node
        return prev;
    }
}
