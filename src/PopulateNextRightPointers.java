/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
public class PopulateNextRightPointers {
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode levelHead = root;
		while (true) {
			TreeLinkNode node = levelHead;
			if (levelHead.left == null) return;
			levelHead = levelHead.left;
			
			node.left.next = node.right;
			while (node.next != null) {
				node.right.next = node.next.left;
				node = node.next;
				node.left.next = node.right;
			}
		}
	}
}