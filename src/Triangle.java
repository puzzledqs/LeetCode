import java.util.*;
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	if (triangle == null || triangle.size() == 0) return 0;
	
	int n = triangle.size();
	int[] sum = new int[n];
        for (int j = 0; j < triangle.get(n-1).size(); j++)
            sum[j] = triangle.get(n-1).get(j);
    	for (int i = n - 1; i >= 1; i--) {
            ArrayList<Integer> tmpList = triangle.get(i - 1);
            for (int j = 0; j < tmpList.size(); j++)
                sum[j] = tmpList.get(j) + (sum[j] < sum[j + 1] ? sum[j] : sum[j + 1]);
        }
	return sum[0];
    }
}
