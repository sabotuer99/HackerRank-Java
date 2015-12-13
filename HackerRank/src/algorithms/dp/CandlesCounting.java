package algorithms.dp;

import java.util.Scanner;

public class CandlesCounting {

	public static final int MAX_N = 50000;
	public static final int MAX_K = 7;
	public static final int MAX_H = 50000;
	public static final int mod = 1000000007;
	public static int[] fenwickTree;

	public static int modAdd(int a, int b) {
		a += b;
		if (a >= mod)
			a -= mod;
		return a;
	}

	public static void update(int i, int x) {
		for (; i <= MAX_N; i += (i & -i)) {
			fenwickTree[i] = modAdd(fenwickTree[i], x);
		}
	}

	public static int query(int i) {
		int s = 0;
		for (; i > 0; i -= (i & -i))
			s = modAdd(s, fenwickTree[i]);
		return s;
	}

	public static int setBits(int i) {
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		return (((i + (i >>> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int K = in.nextInt();
		int[] Heights = new int[MAX_N + 1];
		int[] Colors = new int[MAX_N + 1];

		for (int i = 0; i < N; i++) {
			Heights[i] = in.nextInt();
			Colors[i] = in.nextInt();
		}

		int result = 0;
		for (int mask = 0; mask < (1 << K); mask++) {

			fenwickTree = new int[MAX_N + 10];

			int tmp = 0;
			for (int i = 0; i < N; i++) {
				if (((mask >>> (Colors[i] - 1)) & 1) == 1) {
					int cnt = 1 + query(Heights[i] - 1);
					update(Heights[i], cnt);
					tmp = modAdd(tmp, cnt);
				}
			}

			if (setBits(mask) % 2 == K % 2) {
				result = modAdd(result, tmp);
			} else {
				result = modAdd(result, mod - tmp);
			}
		}

		System.out.println(result);
	}
}
