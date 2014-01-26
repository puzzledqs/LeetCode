public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        sum -= root.val;
        if (root.left == null && root.right == null)
            return sum == 0;
        if (root.left != null && hasPathSum(root.left, sum)) 
            return true;
        if (root.right != null && hasPathSum(root.right, sum))
            return true;
        return false;
    }
}