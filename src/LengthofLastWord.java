public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int len = 0;
		int i = s.length() - 1;
		while (i >= 0 && s.charAt(i) == ' ') // skip trailing spaces
		    i--;
		while (i >= 0 && s.charAt(i) != ' ') { // count
		    len++;
		    i--;
		}
		return len;
	}
}