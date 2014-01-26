/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;
		
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode n = slow.next;
		slow.next = null;
		ListNode prev = null;
		while (n != null) {
			ListNode tmp = n.next;
			n.next = prev;
			prev = n;
			n = tmp;
		}
		ListNode head2 = prev;
		ListNode dummyHead = new ListNode(0);
		n = dummyHead;
		while (head != null && head2 != null) {
			n.next = head;
			head = head.next;
			n = n.next;
			n.next = head2;
			head2 = head2.next;
			n = n.next;
		}
		if (head != null)
			n.next = head;
		else
			n.next = head2;
		
		head = dummyHead.next;
	}
}