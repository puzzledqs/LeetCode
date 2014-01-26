public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.isEmpty()) return null;
		
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		};
		
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
		for (ListNode node : lists) {
			if (node != null)
				heap.add(node);
		}
		
		ListNode dummyHead = new ListNode(0);
		ListNode n1 = dummyHead;
		while (!heap.isEmpty()) {
			ListNode node = heap.poll();
			n1.next = node;
			n1 = n1.next;
			if (node.next != null)
				heap.add(node.next);
		}
		return dummyHead.next;
	}
}