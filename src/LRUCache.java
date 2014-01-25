import java.lang.reflect.Array;
import java.util.*;

public class LRUCache {
	int space;
	ListNode dummyHead;
	ListNode tail;
	HashMap<Integer, ListNode> key2Prev;
	
	public LRUCache(int capacity) {
		space = capacity;
		dummyHead = new ListNode();
		key2Prev = new HashMap<Integer, ListNode>();
		
	}
	
	public int get(int key) {
		ListNode prevNode = key2Prev.get(key);
		if (prevNode == null) return -1;

		int value = prevNode.next.value;
		moveNodeToFront(prevNode);
		return value;		
	}
	
	public void set(int key, int value) {
		ListNode prevNode = key2Prev.get(key);
		if (prevNode != null) {
			prevNode.next.value = value;
			moveNodeToFront(prevNode);
		} 
		else {
			ListNode tmp = new ListNode();
			tmp.key = key;
			tmp.value = value;
			tmp.next = dummyHead.next;
			if (tmp.next == null) tail = tmp;
			else key2Prev.put(tmp.next.key, tmp);
			dummyHead.next = tmp;
			key2Prev.put(tmp.key, dummyHead);
			
			if (space > 0) space--;
			else {
				int k = tail.key;
				tail = key2Prev.get(k);
				tail.next = null;
				key2Prev.remove(k);
			}
		}
	}
	
	
	private void moveNodeToFront(ListNode prevNode) {
		if (dummyHead == prevNode) return;
		ListNode tmp = prevNode.next;
		
		prevNode.next = tmp.next;
		if (tmp == tail) tail = key2Prev.get(tail.key);
		else key2Prev.put(prevNode.next.key, prevNode);
		
		tmp.next = dummyHead.next;
		key2Prev.put(tmp.next.key, tmp);
		dummyHead.next = tmp;
		key2Prev.put(tmp.key, dummyHead);
	}
}

class ListNode {
	int key;
	int value;
	ListNode next;
	ListNode() {
		next = null;
	}
}