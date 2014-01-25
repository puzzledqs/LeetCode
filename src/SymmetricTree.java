import java.util.*;
public class SymmetricTree {
	public boolean isSymmetric2(TreeNode root) {
		if (root == null) return true;
		return isSymmetricHelper(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		
		Queue<TreeNode> l = new LinkedList<TreeNode>();
		Queue<TreeNode> r = new LinkedList<TreeNode>();
		l.add(root.left); r.add(root.right);
		
		while (!l.isEmpty() && !r.isEmpty()) {
			TreeNode tmpl = l.remove();
			TreeNode tmpr = r.remove();
			if (tmpl == null && tmpr == null) continue;
			if (tmpl == null || tmpr == null) return false;
			if (tmpl.val != tmpr.val) return false;
			l.add(tmpl.left);
			l.add(tmpl.right);
			r.add(tmpr.right);
			r.add(tmpr.left);
		}
		return true;
		
	}
	
	public boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) return true;
		if (root1 == null || root2 == null) return false;
		
		if (root1.val != root2.val) return false;
		if (isSymmetricHelper(root1.left, root2.right) && isSymmetricHelper(root1.right, root2.left))
			return true;
		return false;
	}
}