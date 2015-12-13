package data_structures.trie;

import java.util.Scanner;

public class NoPrefixSet {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner in = new Scanner(System.in);
		int t;
		t = in.nextInt();
		in.nextLine();
		boolean result = true;
		NoPreTrie trie = new NoPreTrie();
		String word = "";

		for (int i = 0; i < t; i++) {
			word = in.nextLine();
			result = trie.insert(word);
			if (!result)
				break;
		}

		if (result) {
			System.out.println("GOOD SET");
		} else {
			System.out.println("BAD SET");
			System.out.println(word);
		}
	}
}

class NoPreTrie {
	class Node {
		Node[] members;
		String value;

		public Node() {
			members = new Node[26];
		}
	}

	Node root = new Node();

	public boolean insert(String value) {
		return insert(value, root, 0);
	}

	private boolean insert(String value, Node node, int index) {
		// System.out.println(value + " " + index);
		if (value == null)
			return true;

		if (node.value != null)
			return false;

		if (index == value.length()) {
			node.value = value;
			return true;
		} else {
			char firstLetter = value.charAt(index);
			int slot = (int) firstLetter - 97;
			Node newNode = new Node();

			if (node.members[slot] != null) {
				if (index == value.length() - 1)
					return false;
				newNode = node.members[slot];
			} else {
				node.members[slot] = newNode;
			}

			return insert(value, newNode, index + 1);
		}
	}
}