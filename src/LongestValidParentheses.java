public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) return 0;
	
		int len = 0;
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				stk.push(i);
			else {
				if (stk.isEmpty() || s.charAt(stk.peek()) == ')')
				stk.push(i);
				else {
					stk.pop();
					int prev_pos = -1;
					if (!stk.isEmpty())
						prev_pos = stk.peek();
					if (i - prev_pos > len)
						len = i - prev_pos;
				}
			}
		}
		return len;
	}
}
