/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConvertSortedListtoBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return new TreeNode(head.val);
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode fast = dummyHead;
		ListNode slow = dummyHead;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		ListNode head2 = mid.next;
		TreeNode newroot = new TreeNode(mid.val);
		newroot.left = sortedListToBST(head);
		newroot.right = sortedListToBST(head2);
		return newroot;
	}
}