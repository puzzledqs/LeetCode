import java.util.*;
public class SurroundedRegion {
	
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) return;
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
					if (board[i][j] == 'O') {
						qx.add(i);
						qy.add(j);
					}
				}
		// BFS
		while (!qx.isEmpty()) {
			int x = qx.remove();
			int y = qy.remove();
			board[x][y] = '.';
			for (int i = 0; i < 4; i++) {
    			int xx = x + dx[i];
    			int yy = y + dy[i];
    			if (isValid(board, xx, yy) && board[xx][yy] == 'O') {
    				qx.add(xx);
    				qy.add(yy);
    			}
			}
		}
		
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '.')
					board[i][j] = 'O';
			}
	}
	
	int[] dx = {1, 0, -1, 0};
	int[] dy = {0, 1, 0, -1};
	
	void replace(char[][] board, char a, char b, int x, int y) {
		board[x][y] = b;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (isValid(board, xx, yy) && board[xx][yy] == a)
				replace(board, a, b, xx, yy);
		}
	}
	
	boolean isValid(char[][] board, int x, int y) {
		return (0 <= x && x <= board.length - 1 && 0 <= y && y <= board[0].length - 1);
	}
}