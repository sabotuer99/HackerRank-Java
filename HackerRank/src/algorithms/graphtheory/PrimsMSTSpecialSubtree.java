package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsMSTSpecialSubtree {

	public static void log(Object message) {
		System.out.println(message);
	}

	static class EdgeComparator implements Comparator<Edge> {
		public int compare(Edge e1, Edge e2) {
			return e1.distance - e2.distance;
		}
	}

	public static class Edge {

		public Edge(Integer endpoint, Integer distance) {
			this.endpoint = endpoint;
			this.distance = distance;
		}

		Integer endpoint;
		Integer distance;

		@Override
		public String toString() {
			return "D: " + distance.toString() + " E: " + endpoint.toString();
		}
	}

	public static int Prim(HashMap<Integer, ArrayList<Edge>> Graph,
			Integer source, boolean[] seen) {
		seen[source - 1] = true;

		PriorityQueue<Edge> Q = new PriorityQueue<Edge>(seen.length,
				new EdgeComparator());

		for (Edge e : Graph.get(source)) {
			Q.add(e);
		}

		int total = 0;

		while (Q.size() > 0) {

			Edge node = Q.poll();

			if (!seen[node.endpoint.intValue() - 1]) {
				total += node.distance;
				seen[node.endpoint - 1] = true;

				for (Edge e : Graph.get(node.endpoint)) {
					Q.add(e);
				}
			}
		}

		return total;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = 1;
		for (; T > 0; T--) {
			int N = in.nextInt();
			int M = in.nextInt();
			Integer[] dist = new Integer[N + 1];
			Integer[] prev = new Integer[N + 1];

			HashMap<Integer, ArrayList<Edge>> Graph = new HashMap<Integer, ArrayList<Edge>>();

			for (int i = 0; i < M; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				int r = in.nextInt();

				ArrayList<Edge> xN = Graph.get(x);
				ArrayList<Edge> yN = Graph.get(y);

				if (xN == null) {
					xN = new ArrayList<Edge>();
				}

				if (yN == null) {
					yN = new ArrayList<Edge>();
				}

				xN.add(new Edge(y, r));
				yN.add(new Edge(x, r));

				Graph.put(x, xN);
				Graph.put(y, yN);
			}

			int source = in.nextInt();

			boolean[] seen = new boolean[N];

			System.out.println(Prim(Graph, source, seen));

		}
	}

}
