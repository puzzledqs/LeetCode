public class PopulateNextRightPointersII {
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode levelHead = root;
		while (true) {
			TreeLinkNode node = levelHead;
			levelHead = levelHead.left;
			
			if (levelHead == null)
				levelHead = node.left != null ? node.left : node.right;
			if (node.left != null && node.right != null)
				node.left.next = node.right;
			TreeLinkNode prevNode = null;
			TreeLinkNode nextNode = null;
			while (node.next != null) {
				if (prevNode == null) // search for prev node
					prevNode = node.right != null ? node.right : node.left;
				if (prevNode != null) {// search for next node
					nextNode = node.next.left != null ? node.next.left : node.next.right;
					if (nextNode != null) {
						prevNode.next = nextNode;  // connect prev to next
						prevNode = null;
						nextNode = null;
					}
				}
				
				node = node.next;
				if (levelHead == null)
					levelHead = node.left != null ? node.left : node.right;
				if (node.left != null && node.right != null)
					node.left.next = node.right;
			}
			if (levelHead == null) return;
		}
	}
}