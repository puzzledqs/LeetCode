public class Permutations {
	ArrayList<ArrayList<Integer>> result;
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) return result;
		
		permute(num, 0);
		return result;
    }
	
	void permute(int[] num, int start) {
		if (start == num.length - 1) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (int i = 0; i < num.length; i++)
				tmp.add(num[i]);
			result.add(tmp);
			return;
		}
			
		int v = num[start];
		for (int k = start; k < num.length; k++) {
			num[start] = num[k];
			num[k] = v;
			permute(num, start + 1);
			num[k] = num[start];
		}
		num[start] = v;
	}
}