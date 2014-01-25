public class ValidParentheses {
	public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        
        Stack<Character> stk = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                stk.push(ch);
            else {
                if (stk.isEmpty()) return false;
                char target = ' ';
                switch(ch) {
                    case ')': target = '('; break;
                    case '}': target = '{'; break;
                    case ']': target = '['; break;
                }
                if (stk.pop() != target)
                    return false;
            }
        }
        return stk.isEmpty();
    }
}