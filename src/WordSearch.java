public class WordSearch {
	public int[] dx = {1, 0, -1, 0};
	public int[] dy = {0, 1, 0, -1};
	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0) return true;
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;
		boolean[][] visit = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (word.charAt(0) == board[i][j] && dfs(board, visit, i, j, 1, word))
					return true;
		return false;
	}
	
	// search for the dth character from around current position (row, col)
	boolean dfs(char[][] board, boolean[][] visit, int row, int col, int d, String word) {
		if (d == word.length()) return true;
		visit[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int r = row + dx[i];
			int c = col + dy[i];
			if (isValid(visit, r, c) && word.charAt(d) == board[r][c]) {
				if (dfs(board, visit, r, c, d + 1, word)) {
					visit[row][col] = false;
					return true;
				}
			}
		}
		visit[row][col] = false;
		return false;
	}
	
	boolean isValid(boolean[][] visit, int r, int c) {
		if (r < 0 || r >= visit.length) return false;
		if (c < 0 || c >= visit[0].length) return false;
		return !visit[r][c];
	}
}