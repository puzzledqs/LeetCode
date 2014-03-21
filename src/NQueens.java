public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] num = new int[n];
        for (int i = 0; i < n; i++)
            num[i] = i;
        solve(result, 0, num);
        return result;
    }
    
    public void solve(ArrayList<String[]> result, int d, int[] num) {
        int n = num.length;
        if (d == num.length) {
            String[] res = new String[n];
            char[] tmp = new char[n];
            Arrays.fill(tmp, '.');
            for (int i = 0; i < n; i++) {
                tmp[num[i]] = 'Q';
                res[i] = String.valueOf(tmp);
                tmp[num[i]] = '.';
            }
            result.add(res);
            return;
        }
        
        int val = num[d];
        for (int i = d; i < num.length; i++) {
            num[d] = num[i];
            num[i] = val;
            if (check(num, d))
                solve(result, d + 1, num);
            num[i] = num[d];
        }
        num[d] = val;
    }
    
    boolean check(int[] num, int d) {
        for (int i = 0; i < d; i++) {
            if (Math.abs(num[i] - num[d]) == (d - i))
                return false;
        }
        return true;
    }
}
