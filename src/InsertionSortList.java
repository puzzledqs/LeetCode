//Sort a linked list using insertion sort.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null) return head;
		
		ListNode dummyHead = new ListNode(0);
		while (head != null) {
			ListNode n = dummyHead;
			while (n.next != null) {
				if (n.next.val > head.val)
					break;
				n = n.next;
			}
			ListNode tmp = head;
			head = head.next;
			tmp.next = n.next;
			n.next = tmp;
		}
		return dummyHead.next;
	}
}