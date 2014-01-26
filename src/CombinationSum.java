import java.util.*;
public class CombinationSum {
	ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (candidates == null || candidates.length == 0) {
    	    if (target == 0) {
    	        result.add(new ArrayList<Integer>());
    	    }
    	    return result;
    	}
    	
    	Arrays.sort(candidates);
    	LinkedList<Integer> cur_res = new LinkedList<Integer>();
    	dfs(result, cur_res, candidates, 0, target);
    	return result;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> result, LinkedList<Integer> cur_res, int[] candidates, int start, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(cur_res));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                break;
            target -= candidates[i];
            cur_res.add(candidates[i]);
            dfs(result, cur_res, candidates, i, target);
            target += candidates[i];
            cur_res.removeLast();
        }
    }
}