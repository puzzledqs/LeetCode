public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n < 1) return result;
		
		char[] str = new char[2 * n];
		dfs(str, 0, 0, result);
		return result;
	}
	
	void dfs(char[] str, int left, int right, ArrayList<String> result) {
	    int n = str.length / 2;
	    if (left == n && right == n) {
	        result.add(String.valueOf(str));
	        return;
	    }
	    int pos = left + right;
	    if (left < n) {
	        str[pos] = '(';
	        dfs(str, left + 1, right, result);
	    }
	    if (left > right) {
	        str[pos] = ')';
	        dfs(str, left, right + 1, result);
	    }
	}
}