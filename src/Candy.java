public class Candy {
	public int candy(int[] ratings) {
		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];
		
		for (int i = 0; i < ratings.length; i++) {
			if (i == 0) {
				left[i] = 1;
				right[ratings.length -1] = 1;
			}
			else {
				if (ratings[i] > ratings[i-1])
					left[i] = left[i-1] + 1;
				else
					left[i] = 1;
				
				int right_pos = ratings.length -1 - i;
				if (ratings[right_pos] > ratings[right_pos + 1])
					right[right_pos] = right[right_pos + 1] + 1;
				else
					right[right_pos] = 1;
			}
		}
		int result = 0;
		for (int i = 0; i < ratings.length; i++)
			result += left[i] > right[i] ? left[i] : right[i];
		
		return result;
	}	
}