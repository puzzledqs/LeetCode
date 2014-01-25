public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int max = 1;
		Set<Character> dict = new HashSet<Character>();
		int l = 0, r = 0;
		while (r < s.length()) {
			if (!dict.contains(s.charAt(r)))
				dict.add(s.charAt(r));
			else {
				while (s.charAt(l) != s.charAt(r)) {
					dict.remove(s.charAt(l));
					l++;
				}
				l++;
			}
			r++;
			if (r - l > max)
				max = r - l;
		}
		return max;
	}
}