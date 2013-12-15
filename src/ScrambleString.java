
public class ScrambleString 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String s1 = "abcdefghijklmnopq";
		String s2 = "efghijklmnopqcadb";
		ScrambleString test = new ScrambleString();
		System.out.println(test.isScramble(s1, s2));
		
	}
	
	public boolean isSameCharset(String s1, String s2) {
		int[] hash = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			hash[s1.charAt(i) - 'a']++;
			hash[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < hash.length; i++)
			if (hash[i] != 0)
				return false;
		return true;
	}
	
	public boolean isScramble3(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		
		if (s1.length() != s2.length())
			return false;
		
		int l = s1.length();
		
		for (int split = 1; split < l; split++) {
			if (isSameCharset(s1.substring(0, split), s2.substring(0, split))
					&& isSameCharset(s1.substring(split), s2.substring(split))) {
				boolean left = isScramble3(s1.substring(0, split), s2.substring(0, split));
				boolean right = isScramble3(s1.substring(split), s2.substring(split));
				if (left && right) {
					return true;
				}
			}
			
			if (isSameCharset(s1.substring(0, split), s2.substring(s2.length()-split))
					&& isSameCharset(s1.substring(split), s2.substring(0, s2.length()-split))) {
				boolean left = isScramble3(s1.substring(0, split), s2.substring(s2.length()-split));
				boolean right = isScramble3(s1.substring(split), s2.substring(0, s2.length()-split));
				if (left && right) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean isScramble(String s1, String s2) 
	{
		if (s1.length() != s2.length())
			return false;
		int l = s1.length();
		
		int[][][] matchResults = new int[l][l][l+1]; // [s2 start] [s1 start] [length]
		for (int i = 0; i < l; i++) 
		{
			for (int j = 0; j < l; j++) 
			{
				if (s2.charAt(j) == s1.charAt(i))
					matchResults[j][i][1] = 1;		
			}
		}
		
		for (int ll = 2; ll <= l; ll++)
		{
			for (int start2 = 0; start2 < l; start2++)
			{
				int end2 = start2 + ll - 1;
				if (end2 > l-1)
					break;
				
				for (int start1 = 0; start1 < l; start1++)
				{
					int end1 = start1 + ll - 1;
					if (end1 > l -1)
						break;
					
					for (int split = 1; split < ll; split++)
					{
						// original order
						if (matchResults[start2][start1][split] == 1
								&& matchResults[start2+split][start1+split][ll-split] == 1)
						{
							matchResults[start2][start1][ll] = 1;
							continue;
						}
						
						// reverse order
						if (matchResults[start2][end1-split+1][split] ==  1
								&& matchResults[start2+split][start1][ll-split] == 1)
						{
							matchResults[start2][start1][ll] = 1;
							continue;
						}
					}
				}
				
			}
		}
		return matchResults[0][0][l] == 1;
		
    }
}
