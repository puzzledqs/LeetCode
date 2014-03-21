import java.util.*;
public class UniqueBSTII {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }
    
    public ArrayList<TreeNode> generateTreesHelper(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> ltrees = generateTreesHelper(start, i - 1);
            ArrayList<TreeNode> rtrees = generateTreesHelper(i + 1, end);
            for (TreeNode l : ltrees) {
                for (TreeNode r : rtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;    
    }
}
