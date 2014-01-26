import java.util.*;
public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        
        LinkedList<Integer> cur_res = new LinkedList<Integer>();
        findPath(result, cur_res, root, sum);
        return result;
    }
    
    void findPath(ArrayList<ArrayList<Integer>> result, LinkedList<Integer> cur_res, TreeNode root, int sum) {
        sum -= root.val;
        cur_res.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<Integer>(cur_res));
            }
            cur_res.removeLast();
            return;
        }
        
        if (root.left != null)
            findPath(result, cur_res, root.left, sum);
        if (root.right != null)
            findPath(result, cur_res, root.right, sum);
        cur_res.removeLast();
    }
}