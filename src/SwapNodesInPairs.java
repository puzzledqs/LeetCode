public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) return null;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		while (prev.next != null && prev.next.next != null) {
			ListNode n1 = prev.next;
			ListNode n2 = n1.next;
			prev.next = n2;
			n1.next = n2.next;
			n2.next = n1;
			prev = n1;
		}
		return dummyHead.next;
	}
}