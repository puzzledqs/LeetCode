public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n) return head;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;  // add dummy node to make it invariant to edge case
		ListNode n_cur = dummyHead;
		for (int i = 0; i < m - 1; i++) {
			n_cur = n_cur.next;
		}
		ListNode n1 = n_cur;
		ListNode prev = null;
		n_cur = n_cur.next;
		ListNode next;
		
		for (int i = m; i <=n; i++) {
			next = n_cur.next;
			n_cur.next = prev;
			prev = n_cur;
			n_cur = next;
		}
		n1.next.next = n_cur;
		n1.next = prev;
		
		return dummyHead.next;
	}
}