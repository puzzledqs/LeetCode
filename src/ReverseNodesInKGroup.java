public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) return null;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		
		while (true) {
		    ListNode n1 = prev.next;
		    ListNode n2 = null;
		    int cnt = 0;
		    while (cnt < k && n1 != null) {
		        ListNode tmp = n1.next;
		        n1.next = n2;
		        n2 = n1;
		        n1 = tmp;
		        cnt++;
		    }
		    if (cnt < k) {  // if less than k nodes remain, reverse again and break;
		        n1 = n2;
		        n2 = null;
		        while (cnt > 0) {
		            ListNode tmp = n1.next;
		            n1.next = n2;
		            n2 = n1;
		            n1 = tmp;
		            cnt--;
		        }
		        break;
		    }
		    prev.next.next = n1;
		    n1 = prev.next;
		    prev.next = n2;
		    prev = n1;
		}
		return dummyHead.next;
	}
}