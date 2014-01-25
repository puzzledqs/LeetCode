public class BalancedBinaryTree {
	static boolean balance;
	public boolean isBalanced(TreeNode root) {
		balance = true;
		if (root == null) return true;
		
		getDepth(root);
		return balance;
	}
	
	int getDepth(TreeNode node) {
		if (node == null) return 0;
		if (!balance) return 0;
		int ldepth = getDepth(node.left);
		int rdepth = getDepth(node.right);
		if (ldepth - rdepth > 1 || rdepth - ldepth > 1)
			balance = false;
		int max = ldepth > rdepth ? ldepth : rdepth;
		return max + 1;
	}
}