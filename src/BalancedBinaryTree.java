public class BalancedBinaryTree {
	boolean balance;
    public boolean isBalanced(TreeNode root) {
        balance = true;
        check(root);
        return balance;
    }
    
    int check(TreeNode root) {
        if (root == null) return 0;
        if (!balance) return 0;
        
        int left = check(root.left);
        int right = check(root.right);
        if (left - right > 1 || right - left > 1)
            balance = false;
        return 1 + (left > right ? left : right);
    }
}