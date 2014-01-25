import java.util.*;
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		Queue<TreeNode> l = new LinkedList<TreeNode>();
		Queue<TreeNode> r = new LinkedList<TreeNode>();
		l.add(p);
		r.add(q);
		while (!l.isEmpty() && !r.isEmpty()) {
			TreeNode tmpl = l.remove();
			TreeNode tmpr = r.remove();
			if (tmpl == null && tmpr == null) continue;
			if (tmpl == null || tmpr == null) return false;
			if (tmpl.val != tmpr.val) return false;
			l.add(tmpl.left);
			l.add(tmpl.right);
			r.add(tmpr.left);
			r.add(tmpr.right);
		}
		return true;
	}
}