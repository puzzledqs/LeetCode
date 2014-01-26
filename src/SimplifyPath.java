import java.util.*;
public class SimplifyPath {
	public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "/";
        
        String[] tokens = path.split("/");
        LinkedList<String> l = new LinkedList<String>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (str.equals(".") || str.length() == 0)
                continue;
            if (str.equals("..")) {
                if (!l.isEmpty())
                    l.removeLast();
                continue;
            }
            l.add(str);
        }
        if (l.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String s : l)
            sb.append("/" + s);
        return sb.toString();
    }
}