import java.util.*;
public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) return result;
		
		ArrayList<Integer> cur_res = new ArrayList<Integer>();
		dfs(root, result, cur_res, sum);
		return result;
	}
	
	void dfs(TreeNode node, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur_res, int val) {
		if (node.left == null && node.right == null) {
			if (val == node.val) {
				cur_res.add(node.val);
				result.add(new ArrayList<Integer>(cur_res));
				cur_res.remove(cur_res.size() - 1);
			}
			return;
		}
		
		val -= node.val;
		cur_res.add(node.val);
		if (node.left != null)
			dfs(node.left, result, cur_res, val);
		if (node.right != null)
			dfs(node.right, result, cur_res, val);
		cur_res.remove(cur_res.size()-1);
	}
}