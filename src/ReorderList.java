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
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null) return;
		
		int size = 0;
		ListNode n_cur = head;
		while (n_cur != null) {
			size++;
			n_cur = n_cur.next;
		}
		
		int mid = (size + 1) / 2;
		int pos = 1;
		n_cur = head;
		while (pos < mid) {
			pos++;
			n_cur = n_cur.next;
		}
		ListNode head2 = n_cur.next;
		n_cur.next = null;
		
		// reverse the second list
		ListNode n_prev = null;
		n_cur = head2;
		while (n_cur != null) {
			ListNode next = n_cur.next; // save next node
			n_cur.next = n_prev;
			n_prev = n_cur;
			n_cur = next;
		}
		head2 = n_prev;
		// end reverse
		
		// merge two sub-lists
		ListNode head1 = head;
		ListNode dummyHead = new ListNode(0);
		n_cur = dummyHead;
		while (head1!= null && head2 != null) {
			n_cur.next = head1;
			head1 = head1.next;
			n_cur = n_cur.next;
			n_cur.next = head2;
			head2 = head2.next;
			n_cur = n_cur.next;
		}
		if (head1 == null) n_cur.next = head2;
		else n_cur.next = head1;
		head = dummyHead.next;	
		// end merge
	}
}