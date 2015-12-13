package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BreadthFirstSearchShortestReach {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int T, N, M;
		T = in.nextInt();

		for (int i = 0; i < T; i++) {
			N = in.nextInt();
			M = in.nextInt();
			HashMap<Integer, ArrayList<Integer>> edges = new HashMap<Integer, ArrayList<Integer>>();
			for (int j = 0; j < M; j++) {
				int a = in.nextInt();
				int b = in.nextInt();
				if (edges.containsKey(a))
					edges.get(a).add(b);
				else
					edges.put(a, new ArrayList<Integer>(Arrays.asList(b)));

				if (edges.containsKey(b))
					edges.get(b).add(a);
				else
					edges.put(b, new ArrayList<Integer>(Arrays.asList(a)));
			}

			// printGraph(edges);

			int query = in.nextInt();
			ArrayList<Integer> nextNodes = new ArrayList<Integer>(
					Arrays.asList(query));
			int[] distances = new int[N + 1];

			for (int index = 0; index < N + 1; index++)
				distances[index] = -1;

			distances[query] = 0;
			distances[0] = 0;

			for (int iter = 1; nextNodes.size() > 0; iter++) {
				// set distance to nodes in current nextNodes to iter * 6
				ArrayList<Integer> tempNextNode = new ArrayList<Integer>();
				for (Integer node : nextNodes) {
					if (edges.containsKey(node))
						for (Integer neighbor : edges.get(node)) {
							if (distances[neighbor] == -1) {
								distances[neighbor] = iter * 6;
								tempNextNode.add(neighbor);
							}
						}
				}

				nextNodes = tempNextNode;
			}

			// print all the distances
			for (int index = 0; index < N + 1; index++) {
				if (distances[index] != 0)
					System.out.print(distances[index] + " ");
			}
			System.out.println();

		}

	}

	public static void printGraph(HashMap<Integer, ArrayList<Integer>> edges) {
		for (Integer key : edges.keySet()) {
			System.out.println(key + ": "
					+ Arrays.toString(edges.get(key).toArray()));
		}
	}
}
