public class ValidSudoku {
	int N = 9;

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < N; i++) {
			int[] cnt = new int[N];
			for (int j = 0; j < N; j++) {
				int idx = board[i][j] - '1';
				if (idx < 0 || idx >=9) continue;
				if (cnt[idx] >= 1) return false;
				cnt[idx]++;
			}
		}
		for (int i = 0; i < N; i++) {
			int[] cnt = new int[N];
			for (int j = 0; j < N; j++) {
				int idx = board[j][i] - '1';
				if (idx < 0 || idx >=9) continue;
				if (cnt[idx] >= 1) return false;
				cnt[idx]++;
			}
		}
		for (int i = 0; i < N; i += 3) {
			for (int j = 0; j < N; j += 3) {
				int[] cnt = new int[N];
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						int idx = board[i+k][j+l] - '1';
						if (idx < 0 || idx >=9) continue;
						if (cnt[idx] >= 1) return false;
						cnt[idx]++;
					}
				}
			}
		} 
		return true;
	}
}