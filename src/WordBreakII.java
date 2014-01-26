import java.util.*;

public class WordBreakII {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0) return result;
		
		boolean[] match = new boolean[s.length() + 1];
		ArrayList<ArrayList<Integer>> prevPos = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= s.length(); i++)
			prevPos.add(new ArrayList<Integer>());
		
		match[0] = true;
		for (int i = 0; i < s.length(); i++) {
			if (!match[i])
				continue;
			for (String word : dict) {
				int end = word.length() + i;
				if (end <= s.length()) {
					if (s.substring(i, end).equals(word)) {
						match[end] = true;
						prevPos.get(end).add(i);
					}
				}
			}
		}
		String cur_res = "";
		backTrack(result, s, prevPos, cur_res, s.length());
		return result;
	}
	
	void backTrack(ArrayList<String> result, String s, ArrayList<ArrayList<Integer>> prevPos,
					String cur_res, int cur_pos) {
		ArrayList<Integer> pos = prevPos.get(cur_pos);
		for (Integer p : pos) {
			if (p == 0) {
				String new_res = s.substring(0, cur_pos) + cur_res;
				result.add(new_res);
				continue;
			}
			String news = " " + s.substring(p, cur_pos) + cur_res;
			backTrack(result, s, prevPos, news, p);
		}
	}
}