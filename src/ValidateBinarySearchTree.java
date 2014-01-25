public class ValidateBinarySearchTree {
	int prev;
	boolean valid;
	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		prev = Integer.MIN_VALUE;
		valid = true;
		inOrder(root);
		return valid;
	}
	
	void inOrder(TreeNode root) {
		if (root == null || !valid) return;
		
		inOrder(root.left);
		if (prev >= root.val) valid = false;
		else
			prev = root.val;
		inOrder(root.right);
	}
	
	
}