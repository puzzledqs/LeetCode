public class PermutationSequence {
	
	public static void main(String[] args) {
		String result = new PermutationSequence().getPermutation(3, 6);
		System.out.println(result);
		
	}
	
    public String getPermutation(int n, int k) {
        int fac = 1;
        boolean[] has = new boolean[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++)
            fac *= i;
        k--;
        for (int i = n; i >= 1; i--) {
            int j = k / fac;
            k %= fac;
            if (i > 1) fac /= (i - 1);
            int l;
            for (l = 0; l < n; l++) {
                if (has[l]) continue;
                if (j == 0) {
                    has[l] = true;
                    break;
                }
                j--;
            }
            sb.append(l + 1);
        }
        return sb.toString();
    }
}
