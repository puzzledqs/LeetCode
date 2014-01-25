public class RecoverBinarySearchTree {
	TreeNode first;
	TreeNode second;
	TreeNode prev;
	public void recoverTree(TreeNode root) {
		if (root == null) return;
		first = null;
		second = null;
		prev = null;
		inOrder(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}
	
	public void inOrder(TreeNode root) {
		if (root == null) return;
		
		inOrder(root.left);
		if (prev != null && prev.val > root.val) {
			if (first == null)
				first = prev;
			second = root;
		}
		prev = root;
		inOrder(root.right);
	}
}