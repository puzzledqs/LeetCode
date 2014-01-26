/* Sort a linked list in O(n log n) time using constant space complexity.
*/

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
 
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		head = sortList(head);
		head2 = sortList(head2);
		ListNode dummyHead = new ListNode(0);
		ListNode n = dummyHead;
		while (head != null && head2 != null) {
			if (head.val < head2.val) {
				n.next = head;
				head = head.next;
				n = n.next;
			}
			else {
				n.next = head2;
				head2 = head2.next;
				n = n.next;
			}
		}
		if (head != null)
			n.next = head;
		else
			n.next = head2;
		
		return dummyHead.next;
	}
}