package artificial_intelligence.botbuilding;

import java.util.Scanner;

public class BotCleanStochastic {

	static void nextMove(int mrow, int mcol, String[] grid) {
		int n = 5;
		int prow = 0;
		int pcol = 0;

		for (int i = 0; i < n; i++) {
			if (grid[i].contains("d")) {
				prow = i;
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			if (grid[prow].charAt(i) == "d".charAt(0)) {
				pcol = i;
				break;
			}
		}

		if (mrow == prow) {
			if (mcol < pcol)
				System.out.println("RIGHT");
			else if (pcol < mcol)
				System.out.println("LEFT");
			else
				System.out.println("CLEAN");

		} else {
			if (mrow < prow)
				System.out.println("DOWN");
			if (prow < mrow)
				System.out.println("UP");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] pos = new int[2];
		String board[] = new String[5];
		for (int i = 0; i < 2; i++)
			pos[i] = in.nextInt();
		for (int i = 0; i < 5; i++)
			board[i] = in.next();
		nextMove(pos[0], pos[1], board);
	}
}
