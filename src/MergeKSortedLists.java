public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) return null;
		
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				if (n1.val < n2.val) return -1;
				if (n1.val > n2.val) return 1;
				return 0;
			}
		};
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
		
		for (ListNode node : lists) {
			if (node != null)
				heap.add(node);
		}
		ListNode dummyHead = new ListNode(0);
		ListNode n = dummyHead;
		while (!heap.isEmpty()) {
			ListNode node = heap.poll();
			n.next = node;
			n = n.next;
			if (node.next != null)
				heap.add(node.next);
		}
		return dummyHead.next;
	}
}