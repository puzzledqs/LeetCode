public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		return isMatch2(s, p, 0, 0);
	}
	
    boolean isMatch2(String s, String p, int pos1, int pos2) {
		if (pos2 == p.length()) return pos1 == s.length();
		
		// skip as many matched (non-*) characters as possible
		while (pos1 < s.length() && pos2 < p.length() - 1 && p.charAt(pos2 + 1) != '*') {
			if (p.charAt(pos2) != '.' && s.charAt(pos1) != p.charAt(pos2))
				return false;
			pos1++; pos2++;
		}
		
		// reach the last character of p
		if (pos2 == p.length() - 1) {
			if (pos1 != s.length()-1) return false;
			return p.charAt(pos2) == '.' || (s.charAt(pos1) == p.charAt(pos2));
		}
		
		// or reach *
		if (p.charAt(pos2 + 1) == '*') {
			if (isMatch2(s, p, pos1, pos2 + 2)) return true;
			while (pos1 < s.length()) {
				if (s.charAt(pos1) != p.charAt(pos2) && p.charAt(pos2) != '.')
					break;
				if (isMatch2(s, p, pos1 + 1, pos2 + 2)) return true;
				pos1++;
			}
			return false;
		}
		// reach the end of s, but doesn't reach end of p or '*'
		return false;
	}
}