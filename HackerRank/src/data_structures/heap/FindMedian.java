package data_structures.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindMedian {

	static PriorityQueue<Integer> rightQueue;
	static PriorityQueue<Integer> leftQueue;
	static Integer middle;

	public static void add(Integer val) {

		Integer maxLeft = leftQueue.peek();
		Integer minRight = rightQueue.peek();

		// first value
		if (maxLeft == null && minRight == null && middle == null) {
			middle = val;
			return;
		}

		// even number of existing elements
		if (middle == null) {
			if (val > maxLeft && val < minRight) {
				middle = val;
				return;
			} else if (val <= maxLeft) {
				// addToMap(val, left);
				leftQueue.offer(val);
				middle = maxLeft;
				leftQueue.poll();
				// removeFromMap(maxLeft, left);
				// maxLeft = updateLeft();
			} else {
				// addToMap(val, right);
				rightQueue.offer(val);
				middle = minRight;
				rightQueue.poll();
				// removeFromMap(minRight, right);
				// minRight = updateRight();
			}
		} else { // odd number of elements
			if (val <= middle) {
				leftQueue.offer(val);
				rightQueue.offer(middle);
				// addToMap(val, left);
				// addToMap(middle, right);
				// maxLeft = updateLeft();
				// minRight = updateRight();
			} else {
				leftQueue.offer(middle);
				rightQueue.offer(val);
				// addToMap(middle, left);
				// addToMap(val, right);
				// maxLeft = updateLeft();
				// minRight = updateRight();
			}
			middle = null;
		}
	}

	public static Double getMedian() {

		Integer maxLeft = leftQueue.peek();
		Integer minRight = rightQueue.peek();

		if (maxLeft == null && minRight == null && middle == null)
			return null;
		if (middle == null)
			return new Double(maxLeft.longValue() + minRight.longValue()) / 2;
		return middle.doubleValue();
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();

		leftQueue = new PriorityQueue<>(N, Collections.reverseOrder());
		rightQueue = new PriorityQueue<>(N);
		middle = in.nextInt();
		System.out.println(getMedian());

		for (int i = 1; i < N; i++) {
			Integer x = in.nextInt();
			add(x);
			System.out.println(getMedian());
		}
	}
}
