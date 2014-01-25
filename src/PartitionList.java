public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null) return head;
		
		ListNode dummyHead1 = new ListNode(0);
		ListNode dummyHead2 = new ListNode(0);
		ListNode n_cur = head;
		ListNode n_cur1 = dummyHead1;
		ListNode n_cur2 = dummyHead2;
		while (n_cur != null) {
			if (n_cur.val < x) {
				n_cur1.next = n_cur;
				n_cur1 = n_cur1.next;
				n_cur = n_cur.next;
			} else {
				n_cur2.next = n_cur;
				n_cur2 = n_cur2.next;
				n_cur = n_cur.next;
			}
		}
		n_cur1.next = dummyHead2.next;
		n_cur2.next = null;
		return dummyHead1.next;
	}
}