public class RemoveDuplicatesfromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode n_cur = head;
		ListNode prevnode = dummyHead;
		while (n_cur != null) {
			int val = n_cur.val;
			while (n_cur != null && n_cur.val == val)
				n_cur = n_cur.next;
			if (n_cur == prevnode.next.next) { // n_cur moves 1 step only
				prevnode = prevnode.next;
			}
			else {
				prevnode.next = n_cur;
			}
		}
		return dummyHead.next;
	}
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null) return head;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prevnode = dummyHead;
		ListNode n_cur = head;
		int prevval = head.val;
		boolean dup = false;
		
		while (n_cur != null) {
			if (n_cur.next == null || n_cur.next.val != prevval) {
				if (!dup) {
					prevnode = n_cur;
					n_cur = n_cur.next;
				}
				else {
					prevnode.next = n_cur.next;
					n_cur = n_cur.next;
				}
				if (n_cur != null)
					prevval = n_cur.val;
				dup = false;
			}
			else {
				dup = true;
				n_cur = n_cur.next;
			}
		}
		
		return dummyHead.next;
	}
}