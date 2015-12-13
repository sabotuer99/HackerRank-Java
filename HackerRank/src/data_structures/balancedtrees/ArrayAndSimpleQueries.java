package data_structures.balancedtrees;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class ArrayAndSimpleQueries {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner stdin = new Scanner(System.in);

		Integer arrayLen = stdin.nextInt();
		Integer queries = stdin.nextInt();

		Integer[] array = new Integer[arrayLen];
		Treap deck = Treap.build(arrayLen);
		for (int i = 0; i < arrayLen; i++) {
			array[i] = stdin.nextInt();
		}

		for (int index = 0; index < queries; index++) {
			int type = stdin.nextInt();
			int i = stdin.nextInt();
			int j = stdin.nextInt();

			PerformQuery(deck, type, i, j);
		}

		int[] answer = deck.toArray();

		// first part of solution
		System.out.println(Math.abs(array[answer[0] - 1]
				- array[answer[arrayLen - 1] - 1]));

		for (int i = 0; i < arrayLen; i++) {
			System.out.print(array[answer[i] - 1] + " ");
		}

	}

	static void PerformQuery(Treap deck, int type, int i, int j) {

		// take i-1 items from deck
		Treap.splitRecursive(deck, i - 1);
		Treap front = Treap.splitL;
		deck = Treap.splitR;

		// take j - i from deck
		Treap.splitRecursive(deck, j - (i - 1));
		Treap middle = Treap.splitL;
		Treap back = Treap.splitR;

		// Type 1 queries are represented as 1 i j : Modify the given array by
		// removing elements from i to j and adding them to the front.
		if (type == 1) {
			deck = Treap.merge(middle, front);
			deck = Treap.merge(deck, back);
		}

		// Type 2 queries are represented as 2 i j : Modify the given array by
		// removing elements from i to j and adding them to the back.
		else {
			deck = Treap.merge(front, back);
			deck = Treap.merge(deck, middle);
		}

		// System.out.println("**" + Arrays.toString(deck.toArray()));
	}

	// Treap class from
	// https://www.codechef.com/viewsolution/776799
	public static class Treap {
		private final int y;
		private final int value;
		private Treap l, r;
		private boolean reversed;
		private int size;

		void fix() {
			if (reversed) {
				reversed = false;
				if (l != null) {
					l.reversed ^= true;
				}
				if (r != null) {
					r.reversed ^= true;
				}
				Treap tmp = l;
				l = r;
				r = tmp;
			}
		}

		static int size(Treap t) {
			return t == null ? 0 : t.size;
		}

		public Treap(int y, int value, Treap l, Treap r) {
			this.y = y;
			this.value = value;
			this.l = l;
			this.r = r;
			this.size = size(l) + size(r) + 1;
			this.reversed = false;
		}

		static Treap merge(Treap left, Treap right) {
			if (left == null) {
				return right;
			}
			if (right == null) {
				return left;
			}
			left.fix();
			right.fix();
			if (left.y <= right.y) {
				left.r = merge(left.r, right);
				left.size = size(left.l) + size(left.r) + 1;
				return left;
			} else {
				right.l = merge(left, right.l);
				right.size = size(right.l) + size(right.r) + 1;
				return right;
			}
		}

		static Treap splitL, splitR;

		static void splitRecursive(Treap t, int x) {
			if (t == null) {
				splitL = null;
				splitR = null;
				return;
			}
			t.fix();
			if (size(t.l) < x) {
				splitRecursive(t.r, x - size(t.l) - 1);
				t.r = splitL;
				splitL = t;
			} else {
				splitRecursive(t.l, x);
				t.l = splitR;
				splitR = t;
			}
			t.size = size(t.l) + size(t.r) + 1;
		}

		static Random rng = new Random(1);

		static Treap build(int n) {
			Stack<Treap> stack = new Stack<Treap>();
			Treap first = new Treap(rng.nextInt(), 1, null, null);
			stack.add(first);
			Treap root = first;
			for (int i = 2; i <= n; i++) {
				Treap cur = new Treap(rng.nextInt(), i, null, null);
				if (cur.y < root.y) {
					cur.l = root;
					root = cur;
					stack.clear();
				} else {
					while (stack.peek().y > cur.y) {
						stack.pop();
					}
					Treap t = stack.peek();
					cur.l = t.r;
					t.r = cur;
				}
				stack.add(cur);
			}
			root.calcSize();
			return root;
		}

		void calcSize() {
			if (l != null) {
				l.calcSize();
			}
			if (r != null) {
				r.calcSize();
			}
			size = size(l) + size(r) + 1;
		}

		int[] toArray() {
			int[] array = new int[size];
			toArray(array, 0);
			return array;
		}

		private void toArray(int[] array, int off) {
			fix();
			if (l != null) {
				l.toArray(array, off);
				off += l.size;
			}
			array[off++] = value;
			if (r != null) {
				r.toArray(array, off);
			}
		}
	}

}
