public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = 0;
        int left = 0, right = 0;
        boolean[] has = new boolean[256];
        for (; right < s.length(); right++) {
            int idx = (int)s.charAt(right);
            if (!has[idx]) {
                has[idx] = true;
                len = Math.max(len, right - left + 1);
            }
            else {
                while (s.charAt(left) != s.charAt(right)) {
                    has[(int)s.charAt(left)] = false;
                    left++;
                }
                left++;
            }
        }
        return len;
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
