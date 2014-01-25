import java.util.*;
public class PascalTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0) return result;
		
		Integer[] tmp = new Integer[rowIndex + 1];
		for (int i = 0; i < tmp.length; i++)
			tmp[i] = 1;
		
		for (int level = 2; level <= rowIndex; level++) {
			for (int i = level - 1; i >= 1; i--)
				tmp[i] += tmp[i-1];
		}
		
		result = new ArrayList<Integer>(Arrays.asList(tmp));
		return result;
	}
}