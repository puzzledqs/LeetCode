public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int hl = height[left];
            int hr = height[right];
            if (hl < hr) {
                if (hl * (right - left) > max)
                    max = hl * (right - left);
                left++;
            }
            else {
                if (hr * (right - left) > max)
                    max = hr * (right - left);
                right--;
            } 
        }
        return max;
    }
}