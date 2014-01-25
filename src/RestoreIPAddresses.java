import java.util.*;
public class RestoreIPAddresses {
	ArrayList<String> result;
	ArrayList<Integer> positions;
	
	public static void main(String args[]) {
		String s = "25525511135";
		ArrayList<String> result = new RestoreIPAddresses().restoreIpAddresses(s);
		for (String res:result)
			System.out.println(res);
		
	}
	
	public ArrayList<String> restoreIpAddresses(String s) {
		result = new ArrayList<String>();
		positions = new ArrayList<Integer>();
		if (s == null) return result;
		
		dfs(s, 0, 1);
		return result;
	}
	
	void dfs(String s, int start, int depth) {
		for (int pos = start + 1; pos < s.length() && pos < start + 4; pos++) {
			String s1 = s.substring(start, pos);
			if (isValid(s1)) {
				positions.add(pos);
				if (depth < 3)
					dfs(s, pos, depth+1);
				else {
					String s2 = s.substring(pos);
					if (isValid(s2)) {
						String res = getResult(s, positions);
						result.add(res);
					}
				}
				positions.remove(positions.size()-1);
			}
		}
	}
	
	boolean isValid(String s) {
		if (s.length() > 3) return false;
		if (Integer.valueOf(s) > 255) return false;
		if (s.length() > 1 && s.charAt(0) == '0') return false;
		return true;
	}
	
	String getResult(String s, ArrayList<Integer> positions) {
		String ss = "";
		int prev = 0;
		for (int i = 0; i < positions.size(); i++) {
			int pos = positions.get(i);
			ss += s.substring(prev, pos);
			ss += ".";
			prev = pos;
		}
		ss += s.substring(prev);
		return ss;
	}
}