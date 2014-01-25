public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		
		int i = 0;
		int j = 0;
		int j_pos = -1;
		int i_pos = -1;
		while (i < s.length()) {
			if (j != p.length()) {
				if (p.charAt(j) == '*') {
					j_pos = j;
					i_pos = i;
					j++;
					continue;
				}
				if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
					i++;
					j++;
					continue;
				}
			}
			if (j_pos == -1) return false;
			
			j = j_pos + 1;
			i = i_pos + 1;
			i_pos++;
		}
		
		while (j < p.length() && p.charAt(j) == '*')
			j++;
		return j == p.length();
	}
}