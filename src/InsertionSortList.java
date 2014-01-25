//Sort a linked list using insertion sort.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null) return head;
	
		ListNode tmpHead = new ListNode(0);
		ListNode n_cur = head;
		int size = 0;
		
		while (n_cur != null) {
			ListNode n_tmp = tmpHead;
			for (int i = 0; i < size; i++) {
				if (n_tmp.next.val > n_cur.val) break;
				n_tmp = n_tmp.next;
			}
			ListNode tmp = n_cur;
			n_cur = n_cur.next;
			tmp.next = n_tmp.next;
			n_tmp.next = tmp;
			size++;
		}
		return tmpHead.next;
	}
}