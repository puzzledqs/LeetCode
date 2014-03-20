public class JumpGameII {
    public int jump(int[] A) {
        int step = 0;
        int prev_range = -1;
        int range = 0;
        while (range < A.length - 1) {
            int max = range;
            for (int i = prev_range + 1; i <= range; i++) {
                max = Math.max(max, i + A[i]);
            }
            prev_range = range;
            range = max;
            step++;
        }
        return step;
    }
}
