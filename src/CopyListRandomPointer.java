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
		Map<RandomListNode, RandomListNode> old2new = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = null;
		RandomListNode n_cur1 = head;
		RandomListNode n_cur2 = null;
		
		while (n_cur1 != null) {
			RandomListNode tmp;
			if (old2new.containsKey(n_cur1))
				tmp = old2new.get(n_cur1);
			else {
				tmp = new RandomListNode(n_cur1.label);
				old2new.put(n_cur1, tmp);
			}

			RandomListNode randomNode = n_cur1.random;
			RandomListNode newRandomNode;
			if (randomNode != null) {
				if (old2new.containsKey(randomNode))
					newRandomNode = old2new.get(randomNode);
				else {
					newRandomNode = new RandomListNode(randomNode.label);
					old2new.put(randomNode, newRandomNode);
				}
				tmp.random = newRandomNode;
			}
			if (n_cur2 == null) {
				newHead = tmp;
				n_cur2 = tmp;
			}
			else {
				n_cur2.next = tmp;
				n_cur2 = n_cur2.next;
			}
			n_cur1 = n_cur1.next;
		}
		return newHead;
	}
}
