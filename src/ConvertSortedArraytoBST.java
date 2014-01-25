/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedArraytoBST {
	
	
	
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) return null;
		return partialArraytoBST(num, 0, num.length-1);
	}
	
	TreeNode partialArraytoBST(int[] num, int start, int end) {
		if (start > end) return null;
		if (start == end) return new TreeNode(num[start]);
		int mid = (start + end) / 2;
		TreeNode newroot = new TreeNode(num[mid]);
		newroot.left = partialArraytoBST(num, start, mid - 1);
		newroot.right = partialArraytoBST(num, mid + 1, end);
		return newroot;
	}
}