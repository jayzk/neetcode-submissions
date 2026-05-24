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
        //need a data structure that can simulate a reversed linked list, stack
        Stack<ListNode> s = new Stack<>();
        ListNode currNode = head;
        ListNode topNode = null;

        //push nodes into stack
        while(currNode != null) {
            s.push(currNode);
            currNode = currNode.next;
        }

        currNode = head;
        while(currNode.next != s.peek() && currNode != s.peek()) {
            System.out.println(currNode.val);

            topNode = s.pop();
            ListNode next = currNode.next;

            //reorder nodes
            topNode.next = next;
            currNode.next = topNode;

            //update current node 
            currNode = next;
        }

        //ensure last node points to null 
        if(currNode.next == s.peek()) { //even length edge case
            currNode.next.next = null;
        } else { //odd length edge case
            currNode.next = null;
        }
    }
}
