import java.util.*;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0) return result;
		
		int slen = s.length();
		boolean[][] table = new boolean[slen][slen + 1];
		for (int i = 0; i < slen; i++) {
			table[i][i + 1] = true;
			table[i][i] = true;
		}
		for (int l = 2; l <= slen; l++) {
			for (int i = 0; i + l <= slen; i++) {
				int start = i + 1;
				int end = i + l - 1;
				if (table[start][end] && s.charAt(i) == s.charAt(i + l - 1))
					table[i][i+l] = true;
			}
		}
		
		ArrayList<String> cur_res = new ArrayList<String>();
		dfs(result, cur_res, table, s, 0);
		return result;
	}
	
	void dfs(ArrayList<ArrayList<String>> result, ArrayList<String> cur_res, boolean[][] table, String s, int pos) {
		if (pos == s.length()) {
			result.add(new ArrayList<String>(cur_res));
			return;
		}
		for (int i = pos + 1; i <= s.length(); i++) {
			if (table[pos][i]) {
				cur_res.add(s.substring(pos, i));
				dfs(result, cur_res, table, s, i);
				cur_res.remove(cur_res.size() - 1);
			}
		}
	}
}