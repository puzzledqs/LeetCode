/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class SumRootToLeftNumbers {
	public static int sum;
	public int sumNumbers(TreeNode root) {
		sum = 0;
		if (root != null)
			dfs(root, 0);
		return sum;
	}
	
	void dfs(TreeNode node, int val) {
		val = val * 10 + node.val;
		if (node.left == null && node.right == null) {
			sum += val;
			return;
		}
		if (node.left != null)
			dfs(node.left, val);
		if (node.right != null)
			dfs(node.right, val);
	}
}