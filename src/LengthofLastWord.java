public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		int len = 0;
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == ' ') 
				i++;
			else {
				len = 0;
				while (i < s.length() && s.charAt(i) != ' ') {
					len++;
					i++;
				}
			}
		}
		return len;
	}
}