import java.util.*;
public class UniqueBSTII {
	public ArrayList<TreeNode> generateTrees(int n) {
		if (n < 1) return new ArrayList<TreeNode>();
		
		return generateTreesHelper(1, n);
	}
	
	ArrayList<TreeNode> generateTreesHelper(int start, int n) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (n < 1) {
			result.add(null);  // invariant to the case n = 0;
			return result;
		}
		for (int i = start; i < start + n; i++) {
			ArrayList<TreeNode> leftTrees = generateTreesHelper(start, i - start);
			ArrayList<TreeNode> rightTrees = generateTreesHelper(i + 1, start + n - i -1);
			for (int l = 0; l < leftTrees.size(); l++) {
				for (int r = 0; r < rightTrees.size(); r++) {
					TreeNode newroot = new TreeNode(i);
					newroot.left = leftTrees.get(l);
					newroot.right = rightTrees.get(r);
					result.add(newroot);
				}
			}
		}
		return result;
	}
}