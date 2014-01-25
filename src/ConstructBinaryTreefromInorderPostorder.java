class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class ConstructBinaryTreefromInorderPostorder {
	
	public static void main(String args[]) {
		int[] inorder = {-1};
		int[] postorder = {-1};
		new ConstructBinaryTreefromInorderPostorder().buildTree(inorder, postorder);
		
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) return null;
		if (inorder.length == 0 || postorder.length == 0) return null;
		return buildTreeHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
	}
	
	TreeNode buildTreeHelper(int[] inorder, int in_low, int in_high, 
							int[] postorder, int post_low, int post_high) {
		if (in_low > in_high) return null;
		
		TreeNode newroot = new TreeNode(postorder[post_high]);
		int i;
		for (i = in_low; i <= in_high; i++)
			if (inorder[i] == postorder[post_high])
				break;
		int l1 = i - 1 - in_low;
		newroot.left = buildTreeHelper(inorder, in_low, i-1, postorder, post_low, post_low + l1);
		newroot.right = buildTreeHelper(inorder, i+1, in_high, postorder, post_low + l1 + 1, post_high - 1);			
		return newroot;
	}
	
}