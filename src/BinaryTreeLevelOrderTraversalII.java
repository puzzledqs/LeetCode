import java.util.*;
public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            Queue<TreeNode> tmp = new LinkedList<TreeNode>();
            while (!q.isEmpty()) {
                TreeNode n = q.remove();
                res.add(n.val);
                if (n.left != null)
                    tmp.add(n.left);
                if (n.right != null)
                    tmp.add(n.right);
            }
            result.add(0, res);
            q = tmp;
        }
        return result;
    }
}