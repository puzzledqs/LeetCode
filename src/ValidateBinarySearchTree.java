public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isValid(TreeNode root, int min, int max) {
		if (root == null) return true;
		
		if (root.val <= min || root.val >= max)
			return false;
		return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
	}
}