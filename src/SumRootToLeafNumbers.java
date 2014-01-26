/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class SumRootToLeafNumbers {
	int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sum = 0;
        preOrder(root, 0);
        return sum;
    }
    
    void preOrder(TreeNode root, int path) {
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) 
            sum += path;
        else {
            if (root.left != null)
                preOrder(root.left, path);
            if (root.right != null)
                preOrder(root.right, path);
        }
    }
}