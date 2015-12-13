package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class KruskalMSTReallySpecialSubtree {

	// helpful classes
	public static class Edge {
		int weight;
		Vertex u;
		Vertex v;
	}

	public static class Vertex {
		Integer id;
		Vertex parent;
		int rank;
		ArrayList<Edge> edges;

		public Vertex(Integer id) {
			this.id = id;
			edges = new ArrayList<Edge>();
		}
	}

	public static class EdgeComparator implements Comparator<Edge> {
		public int compare(Edge e1, Edge e2) {
			return e1.weight - e2.weight;
		}
	}

	/*
	 * Disjoint set operations
	 * 
	 * function MakeSet(x) x.parent := x x.rank := 0
	 * 
	 * function Union(x, y) xRoot := Find(x) yRoot := Find(y) if xRoot == yRoot
	 * return
	 * 
	 * // x and y are not already in same set. Merge them. if xRoot.rank <
	 * yRoot.rank xRoot.parent := yRoot else if xRoot.rank > yRoot.rank
	 * yRoot.parent := xRoot else yRoot.parent := xRoot xRoot.rank := xRoot.rank
	 * + 1
	 * 
	 * function Find(x) if x.parent != x x.parent := Find(x.parent) return
	 * x.parent
	 */

	public static void MakeSet(Vertex x) {
		x.parent = x;
		x.rank = 0;
	}

	public static void Union(Vertex x, Vertex y) {
		Vertex xRoot = Find(x);
		Vertex yRoot = Find(y);
		if (xRoot == yRoot)
			return;

		// x and y are not already in same set. Merge them.
		if (xRoot.rank < yRoot.rank)
			xRoot.parent = yRoot;
		else if (xRoot.rank > yRoot.rank)
			yRoot.parent = xRoot;
		else {
			yRoot.parent = xRoot;
			xRoot.rank += 1;
		}
	}

	public static Vertex Find(Vertex x) {
		if (x.parent != x)
			x.parent = Find(x.parent);
		return x.parent;
	}

	public static class UDGraph {
		HashMap<Integer, Vertex> graph = new HashMap<Integer, Vertex>();
		List<Edge> edges = new ArrayList<Edge>();

		public List<Edge> getAllEdges() {
			return edges;
		}

		public List<Vertex> V() {
			List<Vertex> verts = new ArrayList<Vertex>();
			for (Integer id : graph.keySet()) {
				verts.add(graph.get(id));
			}
			return verts;
		}

		public Vertex getVertex(Integer id) {
			return graph.get(id);
		}

		public void addEdge(int u, int v, int r) {
			Edge edge = new Edge();
			edge.weight = r;

			Vertex xN = graph.get(u);
			Vertex yN = graph.get(v);

			if (xN == null) {
				xN = new Vertex(u);
			}

			if (yN == null) {
				yN = new Vertex(v);
			}

			xN.edges.add(edge);
			yN.edges.add(edge);
			edge.u = xN;
			edge.v = yN;

			edges.add(edge);
			graph.put(edge.u.id, xN);
			graph.put(edge.v.id, yN);
		}

	}

	/*
	 * KRUSKAL(G): 1 A = ∅ 2 foreach v ∈ G.V: 3 MAKE-SET(v) 4 foreach (u, v)
	 * ordered by weight(u, v), increasing: 5 if FIND-SET(u) ≠ FIND-SET(v): 6 A
	 * = A ∪ {(u, v)} 7 UNION(u, v) 8 return A
	 */

	public static List<Edge> Kruskal(UDGraph G) {
		List<Edge> A = new ArrayList<Edge>();
		for (Vertex v : G.V())
			MakeSet(v);
		List<Edge> all = G.getAllEdges();
		Collections.sort(all, new EdgeComparator());
		for (int i = 0; i < all.size(); i++) {
			Edge edge = all.get(i);
			if (!Find(edge.u).equals(Find(edge.v))) {
				A.add(edge);
				Union(edge.u, edge.v);
			}
		}

		return A;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();

		UDGraph graph = new UDGraph();

		for (int i = 0; i < M; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int r = in.nextInt();

			graph.addEdge(x, y, r);
		}

		// int source = in.nextInt();

		List<Edge> A = Kruskal(graph);
		int total = 0;
		for (Edge e : A) {
			total += e.weight;
		}

		System.out.println(total);
	}
}
