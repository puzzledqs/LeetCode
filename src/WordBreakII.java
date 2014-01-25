import java.util.*;

public class WordBreakII {
	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new Set<String> {{
			add("cat");
			add("cats");
			add("and");
			add("sand");
			add("dog");
		}}
	}
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		boolean[] matchResult = new boolean[s.length()+1];
		ArrayList<ArrayList<Integer>> backPtr = new ArrayList<ArrayList<Integer>>();
		matchResult[0] = true;
		for (int i = 0; i <= s.length(); i++)
			backPtr.add(new ArrayList<Integer>());
		
		for (int i = 1; i <= s.length(); i++) {
			for (String word : dict) {
				int prev_end = i - word.length();
				if (prev_end >= 0) {
					if (matchResult[prev_end] && s.substring(prev_end, i).equals(word)) {
						matchResult[i] = true;
						backPtr.get(i).add(prev_end);
					}
				}
			}
		}
		
		ArrayList<String> result = new ArrayList<String>();
		if (matchResult[s.length()])
			backTrack(s, matchResult, backPtr, s.length(), "", result);
			
		return result;
	}
	
	void backTrack(String s, boolean[] matchResult, ArrayList<ArrayList<Integer>> backPtr, 
					int cur_end, String cur_res, ArrayList<String> result) {
		if (cur_end == 0) {
			result.add(cur_res);
			return;
		}
		
		for (int i = 0; i < backPtr.get(cur_end).size(); i++) {
			int prev_end = backPtr.get(cur_end).get(i);
			String new_res = s.substring(prev_end, cur_end) + " " + cur_res;
			backTrack(s, matchResult, backPtr, prev_end, new_res, result);
		}
	}
}