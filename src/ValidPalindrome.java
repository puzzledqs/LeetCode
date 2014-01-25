public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null) return true;
		if (s.length() == 0) return true;
		
		int left = 0;
		int right = s.length()-1;
		while (true) {
			while (!Character.isLetterOrDigit(s.charAt(left)) && left < right)
				left++;
			while (!Character.isLetterOrDigit(s.charAt(right)) && left < right)
				right--;
			if (left < right) {
				if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
					return false;
				left++; right--;
			}
			else
				return true;
		}
	}
}