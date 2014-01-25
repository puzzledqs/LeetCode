public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null) return head;
		if (n < 1) return head;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode node1 = dummyHead;
		ListNode node2 = dummyHead;
		int cnt = 0;
		int total = 0;
		while (node1.next != null) {
			node1 = node1.next;
			total++;
			cnt++;
			if (cnt > n)
				node2 = node2.next;
		}
		
		if (n >= total) {
			n = n % total;
			if (n == 0)
				return head;
			cnt = total - n;
			node2 = dummyHead;
			while (cnt > 0) {
				node2 = node2.next;
				cnt--;
			}
		}
			
		ListNode newhead = node2.next;
		node1.next = head;
		node2.next = null;
		return newhead;
	}
}