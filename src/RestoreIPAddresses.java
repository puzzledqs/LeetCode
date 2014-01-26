import java.util.*;
public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return result;
        dfs(result, "", s, 0, 1);
        return result;
    }
    
    void dfs(ArrayList<String> result, String cur_res, String s, int start, int d) {
        if (d == 5) {
            if (start == s.length()) {
                result.add(cur_res.substring(0, cur_res.length()-1));
            }
            return;
        }
        
        for (int end = start + 1; end <= s.length() && end <= start + 3; end++) {
            String str = s.substring(start, end);
            int val = Integer.valueOf(str);
            if (str.length() == 2 && val < 10) continue;
            if (str.length() == 3 && (val < 100 || val > 255)) continue;
            dfs(result, cur_res + str + ".", s, end, d + 1);
        }
    }
}