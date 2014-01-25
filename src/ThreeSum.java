public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 3) return result;
		
		Arrays.sort(num);
		int i = 0;
		while (i < num.length - 2){
			int target = -num[i];
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right];
				if (sum == target) {
					ArrayList<Integer> res = new ArrayList<Integer>();
					res.add(num[i]);
					res.add(num[left]);
					res.add(num[right]);
					result.add(res);
					int tmp = num[left];
					while (left < right && num[left] == tmp)
						left++;
					tmp = num[right];
					while (left < right && num[right] == tmp)
						right--;
					continue;
				}
				if (sum < target)
					left++;
				else
					right--;
			}
			int j = i;
			while (j < num.length - 2 && num[j] == num[i])
				j++;
			i = j;
		}
		return result;
	}	
}