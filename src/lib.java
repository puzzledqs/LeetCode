// binary search  FFFFTTT predicate: 1st T, left jump false
// e.g. asending, first >= target
int left, = 0, right = A.length - 1;
while (left <= right) {
	int mid = left + (right - left) / 2;
	if (A[mid] < target)
		left = mid + 1;
	else
		right = mid - 1;
}
//e.g. desending, last >= target --> first < target
while (left <= right) {
	int mid = left + (right - left) / 2;
	if (A[mid] >= target)
		left = mid + 1;
	else
		right = mid - 1;
}

// quick sort
public void qsort(int[] A, int st, int ed) {
	if (st >= ed) return;
	
	int left = st, right = ed;
	int val = A[left];
	while (left < right) {
		while (left < right && A[right] >= val)
			right--;
		if (left < right)
			A[left] = A[right];
		while (left < right && A[left] <= val)
			left++;
		if (left < right)
			A[right] = A[left];
	}
	A[left] = val;
	qsort(A, st, left - 1);
	qsort(A, left + 1, ed);	
}

// quick select   A.length - 1  k:1-based
public int qselect(int[] A, int st, int ed, int k) {
	int len = ed - st;
	assert(1 <= k && k <= len);
	
	int left = st, right = ed;
	int val = A[left];
	while (left < right) {
		while (left < right && A[right] >= val)
			right--;
		if (left < right)
			A[left] = A[right];
		while (left < right && A[left] <= val)
			left++;
		if (left < right)
			A[right] = A[left];
	}
	if (left - st + 1 == k) return val;
	if (left - st + 1 < k)
		return qselect(A, left + 1, ed, k - (left - st + 1));
	else
		return qselect(A, st, left, k);
}

// A.length, B.length  k:1-based
public int findKth(int[] A, int sta, int eda, int[] B, int stb, int edb, int k) {
	int lena = eda - sta;
	int lenb = edb - stb;
	if (lenb < lena)
		return findKth(B, stb, edb, A, sta, eda, k);
	if (lena == 0)
		return B[stb + k -1];
	if (k == 1)
		return A[sta] < B[stb] ? A[sta] : B[stb];
	int pa = K / 2;
	if (pa > lena)
		pa = lena;
	int pb = K - pa;
	if (A[sta + pa - 1] < B[stb + pb  - 1])
		return (A, sta + pa, eda, B, stb, stb + pb, k - pa);
	if (A[sta + pa - 1] > B[stb + pb - 1])
		return (A, sta, sta + pa, B, stb + pb, edb, k - pb);
	return A[sta + pa - 1];
}

// merge sort
public void merge(int[] A, int st, int ed, int[] arr) {
	if (st == ed) return;
	int mid = (st + ed) / 2;
	merge(A, st, mid, arr);
	merge(A, mid + 1, ed, arr);
	int left = st, right = mid + 1;
	int pos = st;
	while (left <= mid && right <=ed) {
		if (A[left] < A[right])
			arr[pos++] = A[left++];
		else
			arr[pos++] = A[right++];
	}
	while (left <= mid)
		arr[pos++] = A[left++];
	while (right <= ed)
		arr[pos++] = A[right++];
	for (int i = st; i <= ed; i++)
		A[i] = arr[i];
}

// stack  loop until
while (!stk.isEmpty() && stk.peek() > h)
	stk.pop();
stk.push();

if (right < A.length && A[qmax.getFirst()] - A[right] <= K && A[right] - A[qmin.getFirst()] <= K) {
	total++;
	while (!qmin.isEmpty() && A[qmin.getLast()] >= A[right])
		qmin.removeLast();
	qmin.addLast(right);
	while (!qmax.isEmpty() && A[qmax.getLast()] <= A[right])
		qmax.removeLast();
	qmax.addLast(right);
	right++;
}


// dfs
// choose k from n
public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	if (k < 0 || k > n) return result;
	
	LinkedList<Integer> cur_res = new LinkedList<Integer>();
	dfs(result, n, k, 0, 1, cur_res);
	return result;
}

void dfs(ArrayList<ArrayList<Integer>> result, int n, int k, int d, int start, LinkedList<Integer> cur_res) {
	if (d == k) {
		result.add(new ArrayList<Integer>(cur_res));
		return;
	}

	for (int i = start; i <= n; i++) {
		cur_res.add(i);
		dfs(result, n, k, d + 1, i + 1, cur_res);
		cur_res.removeLast();
	}
}

// subsets with dup
void dfs(ArrayList<ArrayList<Integer>> result, int[] num, int start, LinkedList<Integer> cur_res) {
	if (start == num.length) {
		result.add(new ArrayList<Integer>(cur_res));
		return;
	}

	int end = start;
	while (end < num.length && num[end] == num[start])
		end++;
	dfs(result, num, end, cur_res);
	for (int i = start; i < end; i++) {
		cur_res.add(num[i]);
		dfs(result, num, end, cur_res);
	}
	for (int i = start; i < end; i++)
		cur_res.removeLast();
}

// combination sums
void dfs(ArrayList<ArrayList<Integer>> result, int[] candidates, int start, int target, LinkedList<Integer> cur_res) {
	if (target == 0) {
		result.add(new ArrayList<Integer>(cur_res));
		return;
	}

	for (int i = start; i < candidates.length; i++) {
		if (candidates[i] <= target) {
			cur_res.add(candidates[i]);
			dfs(result, candidates, i, target - candidates[i], cur_res);
			cur_res.removeLast();
		}
	}
}


// rpoland
	for(int i = 0; i < exp.length(); i++) {
		char c = exp.charAt(i);
		if (Character.isDigit(c))
			result.add(c);

		else {
			if (c == '(') 
				stk.push(c);
			if (c == ')') {
				while (true) {
					char x = stk.pop();
					if (x == '(')
						break;
					result.add(x);
				}
			}
			if (c == '+' || c == '-') {
				while (true) {
					if (stk.isEmpty() || stk.peek() == '(')
						break;
					result.add(stk.pop());
				}
				stk.push(c);
			}
			if (c == '*' || c == '/') {
				while (true) {
					if (stk.isEmpty() || stk.peek() == '(')
						break;
					if (stk.peek() == '+' || stk.peek() == '-') {
						break;
					}
					result.add(stk.pop());
				}
				stk.push(c);
			}
				
		}
	}
	while (!stk.isEmpty())
		result.add(stk.pop());
	return result;
 
// number of ways/methods --> DP
// 所有重复的操作都可以DP
// divide and conque
// First step analysis!!!
// edit distance
public int minDistance(String word1, String word2) {
	int len1 = word1.length();
	int len2 = word2.length();
	
	int[][] dist = new int[len1 + 1][len2 + 1];
	for (int j = 1; j <= len2; j++)
		dist[0][j] = j;
	for (int i = 1; i <= len1; i++)
		dist[i][0] = i;
	for (int i = 1; i <= len1; i++) {
		for (int j = 1; j <= len2; j++) {
			if (word1.charAt(i - 1) == word2.charAt(j - 1))
				dist[i][j] = dist[i - 1][j - 1];
			else
				dist[i][j] = dist[i - 1][j - 1] + 1;
			if (dist[i][j-1] + 1 < dist[i][j])
				dist[i][j] = dist[i][j - 1] + 1;
			if (dist[i - 1][j] + 1 < dist[i][j])
				dist[i][j] = dist[i - 1][j] + 1;
		}
	}
	return dist[len1][len2];
}

// interleave 1-dim
public boolean isInterleave(String s1, String s2, String s3) {
	if (s1.length() + s2.length() != s3.length()) return false;
	
	boolean[] match = new boolean[s2.length() + 1];
	match[0] = true;
	for (int j = 1; j <= s2.length(); j++) {
		if (!match[j - 1]) break;	
		if (s2.charAt(j - 1) == s3.charAt(j - 1))
			match[j]  = true;
	}
	for (int i = 1; i <= s1.length(); i++) {
		match[0] = match[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		for (int j = 1; j <= s2.length(); j++) {
			match[j] =  (match[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
					(match[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
		}
	}
	return match[s2.length()];
}

// 
递增stack  递减stack
递减queue
双端扫描
