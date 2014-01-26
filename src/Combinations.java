import java.util.*;
public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (n < k) return result;
    	if (k == 0) {
    	    result.add(new ArrayList<Integer>());
    	}
    	LinkedList<Integer> cur_res = new LinkedList<Integer>();
    	dfs(result, cur_res, n, 1, k, 1);
    	return result;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> result, LinkedList<Integer> cur_res, int n, int start, int k, int d) {
        if (d == k + 1) {
            result.add(new ArrayList<Integer>(cur_res));
            return;
        }
        
        for (int i = start; i + k - d <= n; i++) {
            cur_res.add(i);
            dfs(result, cur_res, n, i + 1, k, d + 1);
            cur_res.removeLast();
        }
    }
}