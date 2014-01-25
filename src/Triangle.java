import java.util.*;
public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null) return 0;
		if (triangle.size() == 0) return 0;
		Integer[] sum = new Integer[triangle.size()];
		triangle.get(triangle.size()-1).toArray(sum);
		for (int level = triangle.size() - 2; level >= 0; level--) {
			Iterator<Integer> iter = triangle.get(level).iterator();
			int i = 0;
			while (iter.hasNext()) {
				int tmp = sum[i] < sum[i+1] ? sum[i] : sum[i+1];
				sum[i] = iter.next() + tmp;
				i++;
			}
		}
		return sum[0];
	}
}