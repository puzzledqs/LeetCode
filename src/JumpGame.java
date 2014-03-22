public class JumpGame {
    public boolean canJump(int[] A) {
        int prev = -1;
        int range = 0;
        while (range < A.length - 1) {
            int max = range;
            for (int i = prev + 1; i <= range; i++)
                max = Math.max(max, i + A[i]);
            if (max == range) return false;
            prev = range;
            range = max;
        }
        return
    }
}
