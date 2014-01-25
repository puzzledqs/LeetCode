import java.util.*;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		boolean[] matchResult = new boolean[s.length()+1];
		matchResult[0] = true;
		for (int i = 1; i <= s.length() ; i++) {
			for (String word : dict) {
				int prev_end = i - word.length();
				if (prev_end >= 0) {
					if (matchResult[prev_end] == true && s.substring(prev_end, i).equals(word)) {
						matchResult[i] = true;
						break;
					}
				}
			}
		}
		return matchResult[s.length()];
	}
}