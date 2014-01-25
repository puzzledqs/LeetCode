/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class MinimumDepthBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int depth = 0;
		while (true) {
			depth++;
			Queue<TreeNode> tmp = new LinkedList<TreeNode>();
			while (!q.isEmpty()) {
				TreeNode node = q.remove();
				if (node.left == null && node.right == null)
					return depth;
				if (node.left != null)	tmp.add(node.left);
				if (node.right != null) tmp.add(node.right);
			}
			q = tmp;
		}
	}
}