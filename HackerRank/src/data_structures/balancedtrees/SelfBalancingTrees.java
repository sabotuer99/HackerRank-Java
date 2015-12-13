package data_structures.balancedtrees;

public class SelfBalancingTrees {
	static Node newAvlNode(int x, Node left, Node right) {
		Node node = new Node();
		node.val = x;
		node.left = left;
		node.right = right;
		return node;
	}

	static Node insert(Node t, int x) {
		if (t == null)
			t = newAvlNode(x, null, null);
		else if (x < t.val) {
			t.left = insert(t.left, x);
			if (height(t.left) - height(t.right) == 2)
				if (x < t.left.val)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
		} else if (x > t.val) {
			t.right = insert(t.right, x);
			if (height(t.right) - height(t.left) == 2)
				if (x > t.right.val)
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
		} else
			; // Duplicate; do nothing
		t.ht = max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private static Node rotateWithLeftChild(Node k2) {
		Node k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.ht = max(height(k2.left), height(k2.right)) + 1;
		k1.ht = max(height(k1.left), k2.ht) + 1;
		return k1;
	}

	private static Node rotateWithRightChild(Node k1) {
		Node k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.ht = max(height(k1.left), height(k1.right)) + 1;
		k2.ht = max(height(k2.right), k1.ht) + 1;
		return k2;
	}

	private static int height(Node t) {
		return t == null ? -1 : t.ht;
	}

	private static int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	private static Node doubleWithLeftChild(Node k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private static Node doubleWithRightChild(Node k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}
}
