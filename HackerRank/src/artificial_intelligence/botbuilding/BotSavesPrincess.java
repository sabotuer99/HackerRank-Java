package artificial_intelligence.botbuilding;

import java.util.Scanner;

public class BotSavesPrincess {
	static void displayPathtoPrincess(int n, String[] grid) {
		String vertical = "";
		String horizontal = "";

		if (grid[0].contains("p")) {
			vertical = "UP";
			if (grid[0].charAt(0) == "p".charAt(0))
				horizontal = "LEFT";
			else
				horizontal = "RIGHT";
		} else {
			vertical = "DOWN";
			if (grid[n - 1].charAt(0) == "p".charAt(0))
				horizontal = "LEFT";
			else
				horizontal = "RIGHT";
		}

		for (int i = 0; i < (n - 1) / 2; i++) {
			System.out.println(vertical);
			System.out.println(horizontal);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m;
		m = in.nextInt();
		String grid[] = new String[m];
		for (int i = 0; i < m; i++) {
			grid[i] = in.next();
		}

		displayPathtoPrincess(m, grid);
	}
}
