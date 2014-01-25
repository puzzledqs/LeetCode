public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return "";
		
		int begin = 0;
		int max = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			int len;
			len = expandPalindrome(s, i, i);
			if (len > max) {
				max = len;
				begin = i - len / 2;
			}
			len = expandPalindrome(s, i, i + 1);
			if (len > max) {
				max = len;
				begin = i - len / 2 + 1;
			}
		}
		return s.substring(begin, begin + max);
	}
	
	int expandPalindrome(String s, int l, int r) {
		while (l >= 0 && r < s.length()) {
			if (s.charAt(l) != s.charAt(r)) {
				break;
			}
			l--; r++;
		}
		l++; r--;		
		return r - l + 1;
	}
}