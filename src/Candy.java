public class Candy {
	public int candy(int[] ratings) {
    	if (ratings == null || ratings.length == 0)
    		return 0;
    	
    	int[] left = new int[ratings.length];
    	int[] right = new int[ratings.length];
    	left[0] = 1; right[ratings.length - 1] = 1;
    	for (int i = 1; i < ratings.length; i++) {
    		if (ratings[i] > ratings[i - 1])
    			left[i] = left[i - 1] + 1;
    		else
    			left[i] = 1;
    		int r = ratings.length - 1 - i;
    		if (ratings[r] > ratings[r + 1])
    			right[r] = right[r + 1] + 1;
    		else
    			right[r] = 1;
    	}
    	int sum = 0;
    	for (int i = 0; i < ratings.length; i++) {
    		sum += left[i] > right[i] ? left[i] : right[i];
    	}
    	return sum;
    }
}