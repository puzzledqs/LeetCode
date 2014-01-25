public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 4) return result;
		
		Arrays.sort(num);
		int i = 0;
		while (i < num.length - 3) {
			int j = i + 1;
			while (j < num.length - 2) {
				int left = j + 1, right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum == target) {
						ArrayList<Integer> res = new ArrayList<Integer>();
						res.add(num[i]);
						res.add(num[j]);
						res.add(num[left]);
						res.add(num[right]);
						result.add(res);
						left++; right--;
						while (left < right && num[left] == num[left - 1])
							left++;
						while (left < right && num[right] == num[right + 1])
							right--;
						continue;
					}
					if (sum < target)
						left++;
					else
						right--;
				}
				j++;
				while (j < num.length - 2 && num[j] == num[j-1])
					j++;
			}
			i++;
			while (i < num.length - 3 && num[i] == num[i-1])
				i++;
		}
		return result;
	}
}