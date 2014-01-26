public class SqrtX{
	public int sqrt(int x) {
        if (x == 0) return 0;
        int right = 1;
        int xx = x;
        while (xx > 0) {
            right <<= 1;
            xx >>= 2;
        }
        int left = right >> 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid >= mid) 
                left = left + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}