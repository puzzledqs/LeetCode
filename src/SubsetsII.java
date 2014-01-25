import java.util.*;
public class SubsetsII {
	ArrayList<ArrayList<Integer>> result;
	
	public static void main(String args[]) {
		int[] S = {1, 2, 2};
		ArrayList<ArrayList<Integer>> result  = new SubsetsII().subsetsWithDup(S);
		System.out.println(result.size());
		
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		LinkedList<Integer> cur_res = new LinkedList<Integer>();
		dfs(num, 0, cur_res);
		return result;
	}
	
	void dfs(int[] num, int start, LinkedList<Integer> cur_res) {
		if (start == num.length) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(cur_res);
			result.add(tmp);
			return;
		}
		int cnt = 0;
		int i = start;
		while (i < num.length && num[i] == num[start]) {
			cnt++; 
			i++;
		}
		
		dfs(num, start + cnt, cur_res);
		for (i = 0; i < cnt; i++) {
			cur_res.add(num[start+i]);
			dfs(num, start + cnt, cur_res);
		}
		
		for (i = 0; i < cnt; i++)
			cur_res.removeLast();
	}
	
	
	
	
}