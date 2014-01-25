public class StrStr {
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null) return null;
		
		for (int i = 0; i + needle.length() <= haystack.length(); i++) {
			int j;
			for (j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
			if (j == needle.length())
				return haystack.substring(i);
		}
		return null;
	}
}