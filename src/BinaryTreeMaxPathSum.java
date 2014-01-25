class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {val = x;}
}

public class BinaryTreeMaxPathSum {
	static int maxSum;
	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		maxSideSum(root);
		return maxSum;
	}
	
	public int maxSideSum(TreeNode node) {
		if (node == null) return 0;
		
		int leftSideSum = maxSideSum(node.left);
		int rightSideSum = maxSideSum(node.right);
		int cur_sum = node.val;
		if (leftSideSum > 0) cur_sum += leftSideSum;
		if (rightSideSum > 0) cur_sum += rightSideSum;
		if (cur_sum > maxSum) maxSum = cur_sum;
		
		int tmp = leftSideSum > rightSideSum ? leftSideSum : rightSideSum;
		return tmp > 0 ? (tmp + node.val) : node.val;
	}
}