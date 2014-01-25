public class InterleavingString {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		boolean match = new InterleavingString().isInterleave(s1, s2, s3);
		System.out.println(match);
	}
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null) s1 = "";
		if (s2 == null) s2 = "";
		if (s3 == null) s3 = "";
		
		if (s1.length() + s2.length() != s3.length()) return false;
		
		boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
		match[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			match[i][0] = match[i-1][0] && s3.charAt(i-1) == s1.charAt(i-1);
			if (match[i][0] == false)
				break;
		}
		
		for (int j = 1; j <= s2.length(); j++) {
			match[0][j] = match[0][j-1] && s3.charAt(j-1) == s2.charAt(j-1);
			if (match[0][j] == false)
				break;
		}
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				match[i][j] = (match[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1))
							|| (match[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1));
			}
		}
		return match[s1.length()][s2.length()];
	}
}