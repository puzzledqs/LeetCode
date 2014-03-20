public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num.length < 2) return;
        
        int i, j, tmp;
        for (i = num.length - 1; i >= 1; i--) {
            if (num[i] > num[i - 1]) break;
        }
        if (i > 0) {
            j = i;
            while (j < num.length && num[j] > num[i - 1])
                j++;
            j--;
            tmp = num[j];
            num[j] = num[i - 1];
            num[i - 1] = tmp;
        }
        j = num.length - 1;
        while (i < j) {
            tmp = num[j];
            num[j] = num[i];
            num[i] = tmp;
            i++;
            j--;
        }
    }
}
