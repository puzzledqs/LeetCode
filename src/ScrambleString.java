
public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
        if (s1 == null) s1 = "";
        if (s2 == null) s2 = "";
        
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        boolean[][][] match = new boolean[len][len+1][len]; // start1, end1, start2
        for (int i = 0; i < len; i++) {
            for (int k = 0; k < len; k++) {
                if (s1.charAt(i) == s2.charAt(k))
                    match[i][i+1][k] = true;
            }
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i + l <= len; i++) {
                int start1 = i;
                int end1 = i + l;
                for (int k = 0; k + l <= len; k++) {
                    int start2 = k;
                    int end2 = k + l;
                    for (int split1 = 1; split1 < l; split1++) {
                        int split2 = l - split1;
                        if (match[start1][start1+split1][start2+split2]
                            && match[start1+split1][end1][start2]) {
                            match[start1][end1][start2] = true;
                            break;
                        }
                        if (match[start1][start1+split1][start2] 
                            && match[start1+split1][end1][start2+split1]) {
                            match[start1][end1][start2] = true;
                            break;
                        }
                    }
                }
            }
        }
        return match[0][len][0];
    }
}
