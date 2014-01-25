public class WordSearch {
	
	public static void main(String args[]) {
		char[][] board = {{'A', 'B', 'C', 'E'},
							{'S', 'F', 'C', 'S'},
							{'A', 'D', 'E', 'E'}};
		String s = "SEE";
		boolean result = new WordSearch().exist(board, s);
		System.out.println(result);
		
	}
	
	boolean isFind;
	public boolean exist(char[][] board, String s) {
		if (s == null || s.length() == 0) return true;
		if (board == null) return false;
		
		isFind = false;
		boolean[][] flag = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				if (board[i][j] == s.charAt(0))
					dfs(board, flag, s, 0, i, j);
		}
		return isFind;
	}
	
	int[] di = {1, 0, -1, 0};
	int[] dj = {0, 1, 0, -1};
	
	void dfs(char[][] board, boolean[][] flag, String s, int start, int i, int j) {
		if (isFind) return;		
		if (start == s.length()-1) {
			isFind = true;
			return;
		}
		flag[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int ii = i + di[k];
			int jj = j + dj[k];
			if (isValid(flag, ii, jj) && board[ii][jj] == s.charAt(start+1)) {
				dfs(board, flag, s, start + 1, ii, jj);
			}
		}
		flag[i][j] = false;
		
	}
	
	boolean isValid(boolean[][] flag, int i, int j) {
		if (i < 0 || i >= flag.length) return false;
		if (j < 0 || j >= flag[0].length) return false;
		if (flag[i][j] == true) return false;
		return true;
	}
}