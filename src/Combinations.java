import java.util.*;
public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		
		LinkedList<Integer> cur_res = new LinkedList<Integer>();
		dfs(n, 1, k, result, cur_res);
		return result;
	}
	
	void dfs(int n, int pos, int remain, ArrayList<ArrayList<Integer>> result, LinkedList<Integer> cur_res) {
		if (pos == n+1 && remain > 0) return;
		if (remain == 0) {
			result.add(new ArrayList<Integer>(cur_res));
			return;
		}
		
		// no include
		dfs(n, pos + 1, remain, result, cur_res);
		// do include
		cur_res.add(pos);
		dfs(n, pos + 1, remain - 1, result, cur_res);
		cur_res.removeLast();
	}
}