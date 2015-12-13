package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndMiniMax {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = in.nextInt();
		}
		Arrays.sort(array);

		int P = in.nextInt();
		int Q = in.nextInt();

		// degenerate cases: A is not in range P - Q
		if (array[0] > Q) {
			System.out.println(P);
			return;
		}

		if (array[N - 1] < P) {
			System.out.println(Q);
			return;
		}

		// focus on the array elements that matter
		int start = 0;
		for (; array[start + 1] < P && start < N - 2; start++) {
		}
		;
		int end = N - 1;
		for (; array[end - 1] > Q && end > 1; end--) {
		}
		;

		int cases = end - start + 2;
		int[][] dists = new int[cases][2];

		// special cases for ends
		dists[0][1] = P;
		if (P < array[start]) {
			dists[0][0] = array[start] - P;
		} else {
			dists[0][0] = 0;
		}

		dists[cases - 1][1] = Q;
		if (Q > array[end]) {
			dists[cases - 1][0] = Q - array[end];
		} else {
			dists[cases - 1][0] = 0;
		}

		log("Start: " + start + " End:" + end);
		for (int i = 0; i < cases - 2; i++) {

			int intervalDist = Math
					.abs(array[start + i + 1] - array[start + i]) / 2;
			int interval = array[start + i] + intervalDist;

			int[][] intervals = new int[3][2];
			intervals[0][0] = intervalDist;
			intervals[0][1] = interval;
			intervals[1][0] = intervalDist;
			intervals[1][1] = interval;
			intervals[2][0] = intervalDist;
			intervals[2][1] = interval;

			// if interval is < P, take dist from P to next
			if (interval < P) {
				intervals[1][0] = Math.abs(array[i + 1] - P);
				intervals[1][1] = array[i] + intervals[1][0];
			}

			// if interval is > Q, take dist to Q
			if (interval > Q) {
				intervals[2][0] = Math.abs(Q - array[i]);
				intervals[2][1] = array[i] + intervals[2][0];
			}

			for (int[] intvl : intervals) {
				log("Gap " + i + " " + Arrays.toString(intvl));
			}

			dists[i + 1] = minArray(intervals);

		}

		for (int[] dist : dists) {
			log(Arrays.toString(dist));
		}

		int[] miniMax = maxArray(dists);
		System.out.println(miniMax[1]);

		log(Arrays.toString(array));

	}

	public static void log(Object message) {
		// System.out.println(message);
	}

	public static int[] minArray(int[][] tuples) {
		int[] min = tuples[0];
		for (int[] tuple : tuples) {
			if (min[0] > tuple[0]) {
				min = tuple;
			}
		}
		return min;
	}

	public static int[] maxArray(int[][] tuples) {
		int[] max = tuples[0];
		for (int[] tuple : tuples) {
			if (max[0] < tuple[0]) {
				max = tuple;
			}
		}
		return max;
	}

	public static int min(int[] vals) {
		int min = Integer.MAX_VALUE;
		for (int val : vals) {
			min = min > val ? val : min;
		}

		return min;
	}

	public static int max(int[] vals) {
		int max = Integer.MIN_VALUE;
		for (int val : vals) {
			max = max < val ? val : max;
		}

		return max;
	}

}
