/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

import java.util.*;

public class CopyListRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return head;
		
		RandomListNode n = head;
		while (n != null) {
			RandomListNode newNode = new RandomListNode(n.label);
			newNode.next = n.next;
			n.next = newNode;
			n = n.next.next;
		}
		
		n = head;
		while (n != null) {
			if (n.random != null)
				n.next.random = n.random.next;
			n = n.next.next;
		}
		
		RandomListNode dummyHead = new RandomListNode(0);
		RandomListNode n2 = dummyHead;
		n = head;
		while (n != null) {
			n2.next = n.next;
			n2 = n2.next;
			n.next = n.next.next;
			n = n.next;
		}
		return dummyHead.next;	
	}
}
