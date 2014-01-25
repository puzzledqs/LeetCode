public class SudokuSolver {
	int N = 9;
	int[] start_tab = {0, 0, 0, 3, 3, 3, 6, 6, 6};
	public void solveSudoku(char[][] board) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		ArrayList<Integer> col = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if (board[i][j] == '.') {
					row.add(i);
					col.add(j);
				}
		}
		solve(board, row, col, 0);
	}
	
	boolean solve(char[][] board, ArrayList<Integer> row, ArrayList<Integer> col, int d) {
		if (d == row.size()) return true;
		
		int r = row.get(d);
		int c = col.get(d);
		for (int i = 0; i < N; i++) {
			char ch = (char)('1' + i);
			board[r][c] = ch;
			if (isValid(board, r, c))
				if (solve(board, row, col, d+1))
					return true;
			board[r][c] = '.';
		}
		return false;
	}
	
	boolean isValid(char[][] board, int r, int c) {
		char ch = board[r][c];
		for (int i = 0; i < N; i++) {
			if (i != c && board[r][i] == ch) return false;
			if (i != r && board[i][c] == ch) return false;
		}
		for (int i = start_tab[r]; i < start_tab[r] + 3; i++) {
			for (int j = start_tab[c]; j < start_tab[c] + 3; j++) {
				if (i == r && j == c) continue;
				if (board[i][j] == ch) return false;
			}
		}
		return true;
	}
}