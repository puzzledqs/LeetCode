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
	
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = 0;
        int[] lastIdx = new int[256];
        Arrays.fill(lastIdx, -1);
        int left = 0, right = 0;
        for (;right < s.length(); right++) {
            int idx = (int)s.charAt(right);
            if (lastIdx[idx] < left)
                len = Math.max(len, right - left + 1);
            else {
                left = lastIdx[idx] + 1;
            }
            lastIdx[idx] = right;
        }
        return len;
    }
}
