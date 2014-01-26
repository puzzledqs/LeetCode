import java.util.*;
public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            if (target == 0) {
                result.add(new ArrayList<Integer>());
            }
            return result;
        }
        
        Arrays.sort(num);
        LinkedList<Integer> cur_res = new LinkedList<Integer>();
        dfs(result, cur_res, num, 0, target);
        return result;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> result, LinkedList<Integer> cur_res, int[] num, int start, int target){
        if (target == 0) {
            result.add(new ArrayList<Integer>(cur_res));
            return;
        }
        if (start == num.length)
            return;
        int end = start;
        for (; end < num.length; end++)
            if (num[end] != num[start])
                break;
        dfs(result, cur_res, num, end, target);
        int i = start;
        for (; i < end; i++) {
            if (num[start] > target)
                break;
            target -= num[start];
            cur_res.add(num[start]);
            dfs(result, cur_res, num, end, target);
        }
        for (int j = start; j < i; j++)
            cur_res.removeLast();
    }
}