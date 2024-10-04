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
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode ans = new ListNode();
        ListNode temp = head;
        ListNode less = ans;
        ListNode more = null;
        while(temp != null)
        {
            ListNode temp3 = temp.next;
            if(temp.val < x)
            {
                ListNode temp2 = less.next;
                less.next = temp;
                temp.next = temp2;
                less = less.next;
            }
            else
            {
                if( more == null)
                {
                    less.next = temp;
                    more = temp;
                }   
                else
                {
                    more.next = temp;
                    more = more.next;
                }
            }
            temp = temp3;
        }
        if(more != null)
        {
            more.next = null;
        }
        return ans.next;
    }
}