import java.util.*;
public class FlatternBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if (root == null) return;
		
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode prevNode = null;
		stk.push(root);
		while (!stk.isEmpty()) {
			TreeNode thisNode = stk.pop();
			if (thisNode.right != null)
				stk.push(thisNode.right);
			if (thisNode.left != null)
				stk.push(thisNode.left);
			if (prevNode != null) {
				prevNode.left = null;
				prevNode.right = thisNode;
			}
			prevNode = thisNode;
		}
	}
}