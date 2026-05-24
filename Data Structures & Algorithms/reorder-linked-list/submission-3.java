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
        //For this solution, try not to use O(n) space
        //We'll take the second half of the list and reverse it 
        //we'll then interweave and merge this list with the first half

        //find second half of list using fast/slow pointers
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) { //account for both odd & even edge cases
            slow = slow.next;
            fast = fast.next.next;
        }
    
        //reverse second half
        ListNode currNode = slow.next;
        ListNode next = null;
        ListNode prev = null;
        slow.next = null; //disconnect the 2 halves
        while(currNode != null) {
            next = currNode.next; //move next ptr
            
            //reverse ptr
            currNode.next = prev;

            prev = currNode;
            currNode = next;
        }

        //merge lists 
        currNode = head;
        ListNode end = prev;
        while(end != null) {
            ListNode currNext = currNode.next;
            ListNode endNext = end.next;

            //merge lists
            currNode.next = end;
            end.next = currNext;

            //update ptrs
            currNode = currNext;
            end = endNext;
        }
    }
}
