import java.util.*;

public class PalindromePartitioning {
	
	public static void main(String[] args) {
		new PalindromePartitioning().partition("a");
	}
	
	public ArrayList<ArrayList<String>> partition(String s) {
		boolean[][] isPalin = new boolean[s.length()][s.length()+1];
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j <= s.length()-i; j++) {
				if (i == 1) {
					isPalin[j][j+i] = true;
					isPalin[j][j] = true;
				}
				else {
					if (isPalin[j+1][j+i-1] == true && s.charAt(j) == s.charAt(j+i-1))
						isPalin[j][j+i] = true;
				}
			}
		}
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> cur_res = new ArrayList<String>();
		dfs(s, result, isPalin, 0, cur_res);
		return result;
	}
	
	public void dfs(String s, ArrayList<ArrayList<String>> result, boolean[][] isPalin, 
						int cur_pos, ArrayList<String> cur_res) {
		if (cur_pos == s.length()) {
			result.add((ArrayList<String>)cur_res.clone());
			return;
		}
		for (int i = cur_pos + 1; i <= s.length(); i++) {
			if (isPalin[cur_pos][i]) {
				cur_res.add(s.substring(cur_pos, i));
				dfs(s, result, isPalin, i, cur_res);
				cur_res.remove(cur_res.size()-1);
			}
		}				
	}
}