/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
import java.util.*;

public class BinaryTreePostorderTraversal {
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<Record> stk = new Stack<Record>();
		if (root == null) return result;
		
		TreeNode n_cur = root;
		while (n_cur != null) {
			stk.push(new Record(n_cur));
			n_cur = n_cur.left;
		}
		
		while (!stk.isEmpty()) {
			Record rec = stk.pop();
			if (rec.tag == 0) {
				rec.tag = 1;
				stk.push(rec);
				n_cur = rec.node.right;
				while (n_cur != null) {
					stk.push(new Record(n_cur));
					n_cur = n_cur.left;
				}
			}
			else result.add(rec.node.val);
		}
		return result;
	}
}

class Record {
	public TreeNode node;
	int tag;
	public Record(TreeNode _node) {
		node = _node;
		tag = 0;
	}
}