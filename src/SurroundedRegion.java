import java.util.*;
public class SurroundedRegion {
	
	public static void main(String[] args) {
		char[][] board = {{'O', 'O', 'O'}, 
				{'O', 'O', 'O'},
				{'O', 'O', 'O'}};
		new SurroundedRegion().solve(board);
		System.out.println(board[1][1]);
	}
	
	int[] dx = {1, 0, -1, 0};
	int[] dy = {0, 1, 0, -1};
	
	public void solve(char[][] board) {
		if (board == null) return;
		if (board.length == 0) return;
		if (board[0].length == 0) return;
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				qy.add(0); qx.add(i);
			}
			
			if (board[board.length-1][i] == 'O') {
				qy.add(board.length-1); qx.add(i);
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				qy.add(i); qx.add(0);
			}
			if (board[i][board[0].length-1] == 'O') {
				qy.add(i); qx.add(board[0].length-1);
			}
		}
		
		while (!qx.isEmpty()) {
			int x0 = qx.remove();
			int y0 = qy.remove();
			board[y0][x0] = 'z';
			for (int i = 0; i < 4; i++) {
				int x = x0 + dx[i];
				int y = y0 + dy[i];
				if (isValid(board, y, x)) {
					if (board[y][x] == 'O') {
						qy.add(y); qx.add(x);
					}
				}
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'z')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}
	
	boolean isValid(char[][] board, int y, int x) {
		if (x >= 0 && y >= 0 && x < board[0].length && y < board.length)
			return true;
		else
			return false;
	}

}