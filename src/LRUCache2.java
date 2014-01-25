import java.util.*;
public class LRUCache2 {
	int space;
	ListNode head;
	HashMap<Integer, ListNode> key2node;
	
	public LRUCache2 (int capacity) {
		this.space = capacity;
		head = null;
		key2node = new HashMap<Integer, ListNode>();
	}
	
	public int get(int key) {
		ListNode node = key2node.get(key);
		if (node == null) return -1;
		
		int value = node.value;
		moveToFront(node);
		return value;
	}
	
	public void set(int key, int value) {
		ListNode node = key2node.get(key);
		if (node == null) {
			node = new ListNode();
			node.key = key;
			node.value = value;
			addNodeToFront(node);
			key2node.put(key, node);
			
			if (space > 0) space--;
			else {
				int lastkey = removeLastNode();
				key2node.remove(lastkey);
			}
		}
		else {
			node.value = value;
			moveToFront(node);
		}
	}
	
	void moveToFront(ListNode node) {
		if (head == node) return;
		
		node.prev.next = node.next;  // detach
		node.next.prev = node.prev;
		addNodeToFront(node);
	}
	
	int removeLastNode() {
		ListNode lastnode = head.prev;
		lastnode.prev.next = lastnode.next;
		head.prev = lastnode.prev;
		return lastnode.key;
	}
	
	void addNodeToFront(ListNode node) {
		if (head == null) {
			head = node;
			node.prev = node;
			node.next = node;  // circular list
		}
		else {
			node.next = head;
			node.prev = head.prev;
			node.prev.next = node;
			node.next.prev = node;
			head = node;
		}
	}
}

class ListNode {
	int key;
	int value;
	ListNode prev;
	ListNode next;
	
	public ListNode() {
		prev = null;
		next = null;
	}
}