import java.util.*;
public class SurroundedRegion {
	public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        
        Queue<Pair> q = new LinkedList<Pair>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        q.add(new Pair(i, j));
                        board[i][j] = '#';
                    }
                }
            }
        }
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;
            for (int i = 0; i < 4; i++) {
                int new_x = x + dx[i];
                int new_y = y + dy[i];
                if (isValid(board, new_x, new_y) && board[new_x][new_y] == 'O') {
                    q.add(new Pair(new_x, new_y));
                    board[new_x][new_y] = '#';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    
    public boolean isValid(char[][] board, int x, int y) {
        return 0 <= x && x < board.length 
                && 0 <= y && y < board[0].length;
    }
}

class Pair {
    int x;
    int y;
    public Pair(int _x, int _y) {
        x = _x;
        y = _y;
    }
}
