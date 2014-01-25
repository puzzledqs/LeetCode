import java.util.*;
public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		
		Arrays.sort(S);
		LinkedList<Integer> cur_res = new LinkedList<Integer>();
		dfs(S, 0, result, cur_res);
		return result;
	}
	
	void dfs(int[] S, int start, ArrayList<ArrayList<Integer>> result, LinkedList<Integer> cur_res) {
		if (start == S.length) {
			result.add(new ArrayList<Integer>(cur_res));
			return;
		}
		dfs(S, start+1, result, cur_res);
		cur_res.add(S[start]);
		dfs(S, start+1, result, cur_res);
		cur_res.removeLast();
	}
}