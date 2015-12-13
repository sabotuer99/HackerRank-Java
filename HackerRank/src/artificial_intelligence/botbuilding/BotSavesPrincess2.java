package artificial_intelligence.botbuilding;

import java.util.Scanner;

public class BotSavesPrincess2 {

	static void nextMove(int n, int mrow, int mcol, String[] grid) {
		int prow = 0;
		int pcol = 0;

		for (int i = 0; i < n; i++) {
			if (grid[i].contains("p")) {
				prow = i;
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			if (grid[prow].charAt(i) == "p".charAt(0)) {
				pcol = i;
				break;
			}
		}

		if (mrow == prow) {
			if (mcol < pcol)
				System.out.println("RIGHT");
			if (pcol < mcol)
				System.out.println("LEFT");
		} else {
			if (mrow < prow)
				System.out.println("DOWN");
			if (prow < mrow)
				System.out.println("UP");
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, r, c;
		n = in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		in.useDelimiter("\n");
		String grid[] = new String[n];

		for (int i = 0; i < n; i++) {
			grid[i] = in.next();
		}

		nextMove(n, r, c, grid);

	}
}
