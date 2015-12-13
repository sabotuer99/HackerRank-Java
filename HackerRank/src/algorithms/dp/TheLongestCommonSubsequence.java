package algorithms.dp;

import java.util.Scanner;

public class TheLongestCommonSubsequence {

	/*
	 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem#
	 * Computing_the_length_of_the_LCS function LCSLength(X[1..m], Y[1..n]) C =
	 * array(0..m, 0..n) for i := 0..m C[i,0] = 0 for j := 0..n C[0,j] = 0 for i
	 * := 1..m for j := 1..n if X[i] = Y[j] C[i,j] := C[i-1,j-1] + 1 else C[i,j]
	 * := max(C[i,j-1], C[i-1,j]) return C[m,n]
	 */
	public static int LCSLength(int[] X, int[] Y) {
		int m = X.length;
		int n = Y.length;
		int[][] C = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			C[i][0] = 0;
		for (int j = 0; j <= n; j++)
			C[0][j] = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X[i - 1] == Y[j - 1])
					C[i][j] = C[i - 1][j - 1] + 1;
				else
					C[i][j] = Math.max(C[i][j - 1], C[i - 1][j]);
			}
		}
		System.out.println(backtrack(C, X, Y, m, n).trim());
		return C[m][n];
	}

	/*
	 * 
	 * function backtrack(C[0..m,0..n], X[1..m], Y[1..n], i, j) if i = 0 or j =
	 * 0 return "" else if X[i] = Y[j] return backtrack(C, X, Y, i-1, j-1) +
	 * X[i] else if C[i,j-1] > C[i-1,j] return backtrack(C, X, Y, i, j-1) else
	 * return backtrack(C, X, Y, i-1, j)
	 */
	public static String backtrack(int[][] C, int[] X, int[] Y, int i, int j) {
		if (i == 0 || j == 0)
			return "";

		if (X[i - 1] == Y[j - 1])
			return backtrack(C, X, Y, i - 1, j - 1) + " "
					+ Integer.toString(X[i - 1]);
		else {
			if (C[i][j - 1] > C[i - 1][j])
				return backtrack(C, X, Y, i, j - 1);
			else
				return backtrack(C, X, Y, i - 1, j);
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] Y = new int[N];
		int[] X = new int[M];

		for (int i = 0; i < N; i++) {
			Y[i] = in.nextInt();
		}

		for (int i = 0; i < M; i++) {
			X[i] = in.nextInt();
		}

		LCSLength(X, Y);
	}
}
