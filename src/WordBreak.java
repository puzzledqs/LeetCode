import java.util.*;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) return true;
		boolean[] match = new boolean[s.length() + 1];
		match[0] = true;
		for (int i = 0; i < s.length(); i++) {
			if (match[i] == false)
				continue;
			
			for (String w : dict) {
				int end = i + w.length();
				if (end <= s.length() && s.substring(i, end).equals(w))
					match[end] = true;
			}
		}
		return match[s.length()];
	}
}