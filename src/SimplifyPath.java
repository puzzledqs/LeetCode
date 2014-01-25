import java.util.*;
public class SimplifyPath {
	public static void main(String[] args) {
		String path = "///../..///";
		String result = new SimplifyPath().simplifyPath(path);
		System.out.println(result);
	}
	
	public String simplifyPath(String path) {
		Stack<String> stk = new Stack<String>();
		
		String[] tokens = path.split("/");
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].length() == 0 || tokens[i].equals("."))
				continue;
			if (tokens[i].equals("..")) {
				if (!stk.isEmpty())
					stk.pop();
			}
			else {
				stk.push(tokens[i]);
			}
		}
		if (stk.isEmpty()) return "/";
		
		String result = "";
		while (!stk.isEmpty())
			result = "/" + stk.pop() + result;
		return result;
	}
}