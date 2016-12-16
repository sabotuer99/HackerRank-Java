package algorithms.search;

import java.util.Scanner;

public class IceCreamParlor {

    public static int[] getFlavors(int[] icecreams, int money) {

		// map cost to index
		int[] seen = new int[10000];

		// System.out.println(Arrays.toString(icecreams));

		for (int i = 1; i < icecreams.length; i++) {

			// System.out.println(Arrays.toString(seen));

			int cost1 = icecreams[i];
			int cost2 = money - cost1;
			if (cost2 <= 0)
				continue;

			if (seen[cost2] > 0) {
				return new int[] { seen[cost2], i };
			} else {
				seen[cost1] = i;
			}
		}

		return null;

	}
    
    
    public static void main(String[] args) {
        int t;
		int n, m;

		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		for (int test = 0; test < t; test++) {

			m = in.nextInt();
			n = in.nextInt();
			int[] arr = new int[n + 1];

			for (int i = 1; i <= n; i++)
				arr[i] = in.nextInt();

			int[] chosen = getFlavors(arr, m);
			System.out.printf("%d %d\n", chosen[0], chosen[1]);
		}
		in.close();
    }
}
