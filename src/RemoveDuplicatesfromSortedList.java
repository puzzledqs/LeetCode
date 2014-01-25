public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		ListNode n_cur = head;
		int prev = head.val;
		
		while (n_cur.next != null) {
			if (n_cur.next.val == prev) {
				n_cur.next = n_cur.next.next;
			} else {
				n_cur = n_cur.next;
				prev = n_cur.val;
			}
		}
		return head;
	}
}