package algorithms.gametheory;

import java.util.Arrays;
import java.util.Scanner;

public class StonePiles {

	// adapted from
	// http://naturallystupidpotato.blogspot.com/2015/01/hackerrank-stone-piles.html

	public static void compute_sg_fun(int prev, int start, int rest, int key,
			int[] sg, boolean[][] record) {
		for (int i = start; i <= rest / 2; i++) {
			if (rest - i > i) {
				int res = prev ^ sg[i] ^ sg[rest - i];
				record[key][res] = true;
				compute_sg_fun(prev ^ sg[i], i + 1, rest - i, key, sg, record);
			}
		}

		int k = 0;

		while (record[key][k])
			++k;

		sg[key] = k;
	}

	public static void main(String[] args) {

		boolean[][] record = new boolean[51][51];
		int[] sg = new int[51];
		Arrays.fill(sg, -1);
		sg[0] = 0;
		sg[1] = 0;
		sg[2] = 0;
		sg[3] = 1;
		for (int i = 4; i <= 50; i++)
			compute_sg_fun(0, 1, i, i, sg, record);

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (; T > 0; T--) {
			int N = in.nextInt();

			int result = 0;
			for (int i = 0; i < N; i++) {
				int size = in.nextInt();
				result = result ^ sg[size];
			}

			String output = result == 0 ? "BOB" : "ALICE";
			System.out.println(output);
		}
	}
}
