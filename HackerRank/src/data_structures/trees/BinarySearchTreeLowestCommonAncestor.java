package data_structures.trees;

public class BinarySearchTreeLowestCommonAncestor {

	static Node lca(Node root, int v1, int v2) {
		// printNode(root);
		if (v1 > v2) {
			int temp = v1;
			v1 = v2;
			v2 = temp;
		}

		Node node = new Node();

		if (root.data > v1 && root.data < v2)
			node = root;

		if (root.data < v1 && root.data < v2)
			node = lca(root.right, v1, v2);

		if (root.data > v1 && root.data > v2)
			node = lca(root.left, v1, v2);

		if (root.data == v1 && root.data < v2)
			node = root;

		if (root.data > v1 && root.data == v2)
			node = root;

		return node;
	}

	static void printNode(Node root) {
		System.out.println("   " + root.data + "   ");
		System.out.println(" /   \\");
		String left = root.left == null ? "X" : Integer
				.toString(root.left.data);
		String right = root.right == null ? "X" : Integer
				.toString(root.right.data);
		System.out.println(left + "     " + right);
	}

}
