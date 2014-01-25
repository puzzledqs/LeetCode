public class LetterCombinations {
	public String[] board = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null || digits.length() ==0) {
			result.add("");
			return result;
		}
		
		char[] letters = new char[digits.length()];
		dfs(digits, letters, 0, result);
		return result;
	}
	
	void dfs(String digits, char[] letters, int d, ArrayList<String> result) {
		if (d == letters.length) {
			result.add(String.valueOf(letters));
			return;
		}
		
		String str = board[digits.charAt(d) - '0'];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			letters[d] = ch;
			dfs(digits, letters, d+1, result);
		}
	}
}