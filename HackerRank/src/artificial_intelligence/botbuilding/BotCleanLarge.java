package artificial_intelligence.botbuilding;

import java.util.Scanner;

public class BotCleanLarge {

	static void next_move(int mrow, int mcol, int dimh, int dimw, String[] grid) {

		double closest = 99.0;
		int prow = 0;
		int pcol = 0;

		for (int i = 0; i < dimh; i++) {
			for (int j = 0; j < dimw; j++) {
				if (grid[i].charAt(j) == "d".charAt(0)) {
					double dist = Math.sqrt((mrow - i) * (mrow - i)
							+ (mcol - j) * (mcol - j));
					if (dist < closest) {
						prow = i;
						pcol = j;
						closest = dist;
					}
				}
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
		int[] dim = new int[2];
		for (int i = 0; i < 2; i++)
			pos[i] = in.nextInt();
		for (int i = 0; i < 2; i++)
			dim[i] = in.nextInt();
		String board[] = new String[dim[0]];
		for (int i = 0; i < dim[0]; i++)
			board[i] = in.next();
		next_move(pos[0], pos[1], dim[0], dim[1], board);
	}
}
