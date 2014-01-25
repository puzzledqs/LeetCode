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

import javax.swing.tree.TreeNode;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stk = new Stack<TreeNode>();
		
		if (root != null) {
			stk.push(root);
			while (!stk.isEmpty())
			{
				TreeNode n_cur = stk.pop();
				result.add(n_cur.val);
				if (n_cur.right != null) stk.push(n_cur.right);
				if (n_cur.left != null) stk.push(n_cur.left);
				
			}
		}
		return result;
	}
}