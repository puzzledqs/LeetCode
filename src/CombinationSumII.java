import java.util.*;
public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) return result;	
		Arrays.sort(num);
		ArrayList<Integer> cur_res = new ArrayList<Integer>();
		search(result, cur_res, num, target, 0);
		return result;
	}
	
	void search(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur_res, int[] num, int target, int start) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(cur_res));
			return;
		}
		if (start == num.length) return;
		if (target < 0) return;
		
		int i;
		for (i = start; i < num.length; i++)
			if (num[start] != num[i])
				break;
		int end = i;
		
		search(result, cur_res, num, target, end);
		for (i = start; i < end; i++) {
			target -= num[start];
			cur_res.add(num[start]);
			search(result, cur_res, num, target, end);
		}
		for (int j = start; j < i; j++) {
			cur_res.remove(cur_res.size()-1);
		}
	}
	
}