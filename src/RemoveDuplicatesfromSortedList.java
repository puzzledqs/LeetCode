public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
	if (head == null) return head;
		
	ListNode n1 = head;
	while (n1.next != null) {
	    if (n1.next.val == n1.val)
                n1.next = n1.next.next;
	    else
		n1 = n1.next;
	}
	return head;
    }
}
