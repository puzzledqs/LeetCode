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
public class BinaryTreeLevelOrderTraversal {
	ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) return result;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (true) {
			Queue<TreeNode> tmp = new LinkedList<TreeNode>();
			ArrayList<Integer> level = new ArrayList<Integer>();
			while (!q.isEmpty()) {
				TreeNode node = q.remove();
				level.add(node.val);
				if (node.left != null)
					tmp.add(node.left);
				if (node.right != null)
					tmp.add(node.right);
			}
			result.add(level);
			if (tmp.isEmpty()) break;
			q = tmp;
		}
		return result;
	}
}