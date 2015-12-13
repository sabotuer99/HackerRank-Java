package algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner in = new Scanner(System.in);
		int T, N;
		T = in.nextInt();
		List<Integer> prev = new ArrayList<Integer>();

		for (int i = 0; i < T; i++) {
			boolean goodSet = true;
			N = in.nextInt();
			in.nextLine();
			for (int rows = 0; rows < N; rows++) {
				List<Integer> row = new ArrayList<Integer>();
				String line = in.nextLine();
				for (int cols = 0; cols < N; cols++) {
					row.add((int) line.charAt(cols));
				}
				Collections.sort(row);
				if (rows > 0) {
					for (int j = 0; j < N; j++) {
						if (row.get(j) < prev.get(j))
							goodSet = false;
					}
				}
				prev = row;
			}
			if (goodSet)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}
}
