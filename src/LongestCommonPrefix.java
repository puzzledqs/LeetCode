public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (true) {
		    int j;
			for (j = 0; j < strs.length; j++) {
				if (strs[j] == null || strs[j].length() == i)
					break;
				if (strs[j].charAt(i) != strs[0].charAt(i))
					break;
			}
			if (j < strs.length)
				break;
			sb.append(strs[0].charAt(i));
			i++;
		}
		return sb.toString();
	}
}