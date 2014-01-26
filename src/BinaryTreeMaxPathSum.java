class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {val = x;}
}

public class BinaryTreeMaxPathSum {
	int max;
    public int maxPathSum(TreeNode root) {
    	max = Integer.MIN_VALUE;
    	maxSidePathSum(root);
    	return max;
    }
    
    int maxSidePathSum(TreeNode root) {
    	if (root == null) return 0;
    	int leftSum = maxSidePathSum(root.left);
    	int rightSum = maxSidePathSum(root.right);
    	int sum = root.val;
    	if (leftSum > 0) sum += leftSum;
    	if (rightSum > 0) sum += rightSum;
    	if (sum > max) max = sum;
    	
    	int sideSum = leftSum > rightSum ? leftSum : rightSum;
    	return root.val + (sideSum > 0 ? sideSum : 0);
    }
}