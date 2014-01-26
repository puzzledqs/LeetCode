import java.util.*;
public class LRUCache2 {
	ListNode head;
	HashMap<Integer, ListNode> key2node; 
	int capacity;
	int size;
	
	public LRUCache2(int _capacity) {
		head = null;
		key2node = new HashMap<Integer, ListNode>();
		capacity = _capacity;
		size = 0;
	}
	
	public int get(int key) {
		if (!key2node.containsKey(key))
			return -1;
		ListNode n = key2node.get(key);
		moveToFront(n);
		return n.val;
	}
	
	public void set(int key, int val) {
		ListNode n = null;
		if (key2node.containsKey(key)) {
			n = key2node.get(key);
			moveToFront(n);
			n.val = val;
		}
		else {
			n = new ListNode();
			n.key = key; n.val = val;
			insertToFront(n);
			size++;
			if (size > capacity) {
				size--;
				removeFromBack();
			}
		}
	}
	
	void moveToFront(ListNode node) {
		if (node == head) return;
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		node.next = head;
		node.prev = head.prev;
		node.next.prev = node;
		node.prev.next = node;
		head = node;
	}
	
	void insertToFront(ListNode node) {
		if (head == null) {
			head = node;
			head.next = head;
			head.prev = head;
		}
		else {
			node.next = head;
			node.prev = head.prev;
			node.next.prev = node;
			node.prev.next = node;
			head = node;
		}
		key2node.put(node.key, node);
	}
	
	void removeFromBack() {
		ListNode node = head.prev;
		head.prev = node.prev;
		node.prev.next = head;
		key2node.remove(node.key);
	}
}

class ListNode {
	int key;
	int val;
	ListNode prev;
	ListNode next;
	public ListNode() {
		prev = null;
		next = null;
	}
}