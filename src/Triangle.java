import java.util.*;
public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) return 0;
		
		int n = triangle.size();
		int[] sum = new int[n];
		ArrayList<Integer> tmp = triangle.get(n - 1);
		for (int i = 0; i < n; i++)
			sum[i] = tmp.get(i);
		for (int i = n - 2; i >= 0; i--) {
			tmp = triangle.get(i);
			for (int j = 0; j <= i; j++) {
				sum[j] = tmp.get(j) + (sum[j] < sum[j + 1] ? sum[j] : sum[j + 1]);
			}
		}
		return sum[0];
	}
}