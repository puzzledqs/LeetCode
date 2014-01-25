import java.util.*;
public class BinaryTreeZigzagOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) return result;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		boolean left = true;
		q.add(root);
		
		while (true) {
			Queue<TreeNode> tmp = new LinkedList<TreeNode>();
			ArrayList<Integer> level = new ArrayList<Integer>();
			while (!q.isEmpty()) {
				TreeNode node = q.remove();
				if (left)
					level.add(node.val);
				else
					level.add(0, node.val);
				if (node.left != null)
					tmp.add(node.left);
				if (node.right !=null)
					tmp.add(node.right);
			}
			result.add(level);
			if (tmp.isEmpty())
				break;
			q = tmp;
			left = !left;
		}
		return result;
	}
}