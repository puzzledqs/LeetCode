import java.util.*;
public class PascalTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] a = new int[rowIndex + 1];
        a[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            a[rowIndex] = 1;
            for (int j = rowIndex - 1; j >= 1; j--)
                a[j] += a[j - 1];
        }
        for (int i = 0; i < a.length; i++)
            result.add(a[i]);
        return result;
    }
}
