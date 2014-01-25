import java.util.*;
public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0) return triangle;
		
		for (int level = 1; level <= numRows; level++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			if (level == 1) {
				triangle.add(tmp);
				continue;
			}
			
			Iterator<Integer> iter = triangle.get(triangle.size()-1).iterator();
			int prev = iter.next();
			for (int i = 1; i < level - 1; i++) {
				int sum = prev;
				prev = iter.next();
				sum += prev;
				tmp.add(sum);
			}
			tmp.add(1);
			triangle.add(tmp);
		}
		return triangle;
	}
}