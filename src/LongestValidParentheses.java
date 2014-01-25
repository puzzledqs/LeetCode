public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) return 0;
		
		Stack<Integer> stk = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stk.push(i);
			else {
				if (stk.isEmpty()) {
					stk.push(i);
					continue;
				}
				int idx = stk.pop();
				if (s.charAt(idx) == ')') // not match
					stk.push(i);
				else {  // match
					int len = 0;
					if (stk.isEmpty())
						len = i + 1;
					else
						len = i - stk.peek();
					if (len > max)
						max = len;
				}
			}
		}
		return max;
	}
}