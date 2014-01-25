public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		if (n < 1) return result;
		
		int[] pos = new int[n];
		for (int i = 0; i < n; i++)
			pos[i] = i;
		search(pos, 0, result);
		return result;
	}
	
	void search(int[] pos, int d, ArrayList<String[]> result) {
		if (d == pos.length) {
			result.add(generateRes(pos));
			return;
		}
		
		int v = pos[d];
		for (int i = d; i < pos.length; i++) {
			pos[d] = pos[i];
			pos[i] = v;
			if (isValid(pos, d))
				search(pos, d + 1, result);
			pos[i] = pos[d];
		}
		pos[d] = v;
	}
	
	boolean isValid(int[] pos, int d) {
		for (int i = 0; i < d; i++) {
			if (d - i == Math.abs(pos[d] - pos[i]))
				return false;
		}
		return true;
	}
	
	String[] generateRes(int[] pos) {
		String[] res = new String[pos.length];
		for (int i = 0; i < pos.length; i++) {
			char[] charArray = new char[pos.length];
			for (int j = 0; j < charArray.length; j++)
				charArray[j] = '.';
			charArray[pos[i]] = 'Q';
			res[i] = String.valueOf(charArray);
		}
		return res;
	}
}