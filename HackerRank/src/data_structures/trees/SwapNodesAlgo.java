package data_structures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class SwapNodesAlgo {

	public static class Node {
		int data;
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		String line;
		Scanner stdin = new Scanner(System.in);
		// while(stdin.hasNextLine() && !( line = stdin.nextLine() ).equals( ""
		// ))
		// {
		// System.out.println(line);
		// }

		ArrayList<String> nodeDefs = new ArrayList<String>();
		ArrayList<Integer> Ks = new ArrayList<Integer>();

		Integer N = Integer.parseInt(stdin.nextLine());

		for (int i = 0; i < N; i++) {
			nodeDefs.add(stdin.nextLine());
		}

		Integer T = Integer.parseInt(stdin.nextLine());
		for (int i = 0; i < T; i++) {
			Ks.add(Integer.parseInt(stdin.nextLine()));
		}

		Node root = new Node();
		root.data = 1;
		Node indexN = root;
		for (int i = 0; i < N; i++) {
			int left = Integer.parseInt(nodeDefs.get(i).split(" ")[0]);
			int right = Integer.parseInt(nodeDefs.get(i).split(" ")[1]);
			Node node = getNode(root, i + 1);
			if (left != -1) {
				node.left = new Node();
				node.left.data = left;
			}
			if (right != -1) {
				node.right = new Node();
				node.right.data = right;
			}
			// System.out.println(i);
		}

		TreeMap<Integer, List<Node>> map = LevelOrderMap(root);

		// System.out.println("Swaps Starting");
		for (Integer K : Ks) {
			for (int j = 1; j <= map.lastKey(); j++) {
				if (j % K == 0) {
					for (Node node : map.get(j)) {
						swap(node);
					}
				}
			}
			Inorder(root);
			System.out.println();
			// System.out.println("Swap:" + K);
		}

		stdin.close();
	}

	static Node getNode(Node root, int index) {
		if (root == null)
			return null;

		if (index == root.data)
			return root;

		Node node = null;
		if (root.right != null)
			node = getNode(root.right, index);

		if (root.left != null && node == null)
			node = getNode(root.left, index);

		return node;
	}

	static TreeMap<Integer, List<Node>> LevelOrderMap(Node root) {
		List<Node> nextLevel = new ArrayList<Node>();
		TreeMap<Integer, List<Node>> map = new TreeMap<Integer, List<Node>>();
		nextLevel.add(root);
		_level(nextLevel, map, 1);
		return map;
	}

	static void _level(List<Node> root, TreeMap<Integer, List<Node>> map,
			int index) {

		map.put(index, root);
		// System.out.println();
		// System.out.println(index);
		// System.out.println();

		List<Node> nextLevel = new ArrayList<Node>();
		for (Node node : root) {

			if (node != null) {
				// printNode(node);
				// System.out.print(node.data + " ");
				nextLevel.add(node.left);
				nextLevel.add(node.right);
			}
		}

		if (nextLevel.size() > 0)
			_level(nextLevel, map, index + 1);
	}

	static void swap(Node root) {
		// System.out.println("swap called on:");
		// printNode(root);

		if (root == null)
			return;

		Node temp = root.right;
		root.right = root.left;
		root.left = temp;
	}

	static void Inorder(Node root) {
		if (root != null) {
			Inorder(root.left);
			System.out.print(root.data + " ");
			Inorder(root.right);
		}
	}

	static void printNode(Node root) {
		if (root == null) {
			System.out.println("   X   ");
			return;
		}

		System.out.println("   " + root.data + "   ");
		System.out.println(" /   \\");
		String left = root.left == null ? "X" : Integer
				.toString(root.left.data);
		String right = root.right == null ? "X" : Integer
				.toString(root.right.data);
		System.out.println(left + "     " + right);
	}

}
