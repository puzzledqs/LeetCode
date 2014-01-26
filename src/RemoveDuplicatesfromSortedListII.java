public class RemoveDuplicatesfromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode n1 = dummyHead;
		while (n1.next != null) {
			ListNode n2 = n1.next;
			int cnt = 0;
			int val = n2.val;
			while (n2 != null && n2.val == val) {
				cnt++;
				n2 = n2.next;
			}
			if (cnt > 1) 
				n1.next = n2;
			else
				n1 = n1.next;
		}
		return dummyHead.next;
	}
}