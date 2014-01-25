/* Sort a linked list in O(n log n) time using constant space complexity.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class SortList {
	public ListNode sortList(ListNode head) {
        if (head == null) return head;
 		if (head.next == null) return head;
 		
 		int l = 1;
 		ListNode n_cur = head;
 		while (n_cur.next != null) {
 			n_cur = n_cur.next;
 			l++;
 		}
 		
 		l = l / 2;
 		n_cur = head;
 		while (l > 1) {
 			n_cur = n_cur.next;
 			l--;
 		}
 		ListNode head1 = head; // split into two linked lists
 		ListNode head2 = n_cur.next;
 		n_cur.next = null;
 		head1 = sortList(head1);
 		head2 = sortList(head2);
 		
 		ListNode tmpHead = new ListNode(0); // insert a dummy node in the front
 		n_cur = tmpHead;
 		while (head1 != null && head2 != null) {
 			if (head1.val <= head2.val) {
 				n_cur.next = head1;
 				n_cur = head1;
 				head1 = head1.next;
 			}
 			else {
 				n_cur.next = head2;
 				n_cur = head2;
 				head2 = head2.next;
 			}
 		}
 		if (head1 == null) n_cur.next = head2;
 		else n_cur.next = head1;
 		return tmpHead.next;
 		
 		tmpHead.next = head1;
 		head1 = tmpHead;
 	}
}