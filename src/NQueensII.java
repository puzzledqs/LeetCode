public class NQueensII {
	int total;
	public int totalNQueens(int n) {
		if (n < 1) return 0;
		
		total = 0;
		int[] pos = new int[n];
		for (int i = 0; i < pos.length; i++) {
			pos[i] = i;
		}
		search(pos, 0);
		return total;
	}
	
	void search(int[] pos, int d) {
		if (d == pos.length) {
			total++;
			return;
		}
		
		int v = pos[d];
		for (int i = d; i < pos.length; i++) {
			pos[d] = pos[i];
			pos[i] = v;
			if (isValid(pos, d))
				search(pos, d + 1);
			pos[i] = pos[d];
		}
		pos[d] = v;
	}
	
	boolean isValid(int[] pos, int d) {
		for (int i = 0; i < d; i++)
			if (d - i == Math.abs(pos[d] - pos[i]))
				return false;
		return true;
	}
}