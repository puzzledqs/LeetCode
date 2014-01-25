import java.util.*;
public class WordLadder {
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (start.equals(end)) return 0;
		if (dict == null) return 0;
		
		HashSet<String> visit_s = new HashSet<String>();
		HashSet<String> visit_e = new HashSet<String>();
		Queue<String> qstart = new LinkedList<String>();
		Queue<String> qend = new LinkedList<String>();
		
		
		qstart.add(start); visit_s.add(start);
		qend.add(end); visit_e.add(end);
		int len = 1;
		
		while (!qstart.isEmpty() && !qend.isEmpty()) {
			len++;
			Queue<String> qtmp = new LinkedList<String>();
			while (!qstart.isEmpty()) {
				String s = qstart.remove();
				for (int i = 0; i < s.length(); i++) {
					for (int j = 0; j < 26; j++) {
						char newchar = (char)('a' + j);
						if (newchar == s.charAt(i))
							continue;
						char[] charArray = s.toCharArray();
						charArray[i] = newchar;
						String newString = String.valueOf(charArray);
						if (dict.contains(newString)) {
							if (visit_e.contains(newString))
								return len;
							if (!visit_s.contains(newString)) {
								qtmp.add(newString);
								visit_s.add(newString);
							}
						}
					}
				}
			}
			// swap start and end
			qstart = qend;
			qend = qtmp;
			HashSet<String> tmp = visit_e;
			visit_e = visit_s;
			visit_s = tmp;
		}
		return 0;
	}
	
}