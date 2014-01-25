public class ConstructBinaryTreefromPreorderInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) return null;
		if (preorder.length == 0 || inorder.length == 0) return null;
		return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	TreeNode buildTreeHelper(int[] preorder, int pre_low, int pre_high,
								int[] inorder, int in_low, int in_high) {
		if (pre_low > pre_high) return null;
		
		TreeNode root = new TreeNode(preorder[pre_low]);
		int val = preorder[pre_low];
		int i;
		for (i = in_low; i <= in_high; i++) {
			if (inorder[i] == val)
				break;
		}
		int l1 = i - 1 - in_low;
		root.left = buildTreeHelper(preorder, pre_low + 1, pre_low + 1 + l1, inorder, in_low, i - 1);
		root.right = buildTreeHelper(preorder, pre_low + 2 + l1, pre_high, inorder, i + 1, in_high);
		return root; 
	}
}