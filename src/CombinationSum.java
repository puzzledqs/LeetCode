import java.util.*;
public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0)  return result;
		Arrays.sort(candidates);
		ArrayList<Integer> cur_res = new ArrayList<Integer>();
		search(result, cur_res, candidates, target, 0);
		
		return result;
	}
	
	void search(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur_res, int[] candidates, int target, int k) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(cur_res));
			return;
		}
		
		for (int i = k; i < candidates.length; i++) {
			target -= candidates[i];
			if (target < 0) return;
			cur_res.add(candidates[i]);
			search(result, cur_res, candidates, target, i);
			cur_res.remove(cur_res.size()-1);
			target += candidates[i];
		}
	}
}