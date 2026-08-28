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

        if(head == null || head.next == null){
            return head;
        }


        ListNode current = head;
        ListNode newTail = new ListNode(head.val, null);

        while(current != null){
            if(current == head){
                current = current.next;
                continue;
            }

            ListNode newNode = new ListNode(current.val, newTail);
            newTail = newNode;

            if(current.next == null){
                head = newNode;
            }

            current = current.next;
        }
        return head;
    }
}
