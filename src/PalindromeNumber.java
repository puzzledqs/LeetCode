public class PalindromeNumber {
	public boolean isPalindrome(int x) {
    	if (x < 0) return false;
    	
    	int y = 1;
    	while (x / 10 >= y)
    		y *= 10;
    	while (x > 0) {
    		int a = x % 10;
    		int b = x / y;
    		if (a != b) return false;
    		x %= y;
    		x /= 10;
    		y /= 100;
    	}
    	return true;
    }
}