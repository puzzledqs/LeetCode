public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return null;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		int cnt = 0;
		ListNode fast = dummyHead;
		ListNode slow = dummyHead;
		while (fast.next != null) {
			fast = fast.next;
			cnt++;
			if (cnt > n)
				slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummyHead.next;
	}
}