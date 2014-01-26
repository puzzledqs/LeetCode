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
    	while (!q.isEmpty()) {
    	    Queue<TreeNode> tmp = new LinkedList<TreeNode>();
    	    depth++;
    	    while (!q.isEmpty()) {
    	        TreeNode n = q.remove();
    	        if (n.left == null && n.right == null)
    	            return depth;
    	        if (n.left != null)
    	            tmp.add(n.left);
    	        if (n.right != null)
    	            tmp.add(n.right);
    	    }
    	    q = tmp;
    	}
    	return depth;
    }
}