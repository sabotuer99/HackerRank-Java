package algorithms.sorting;

import java.util.Scanner;

public class InsertionSortAdvancedAnalysis {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < n; j++) {
				ar[j] = in.nextInt();
				// System.err.println(ar[j]);
			}
			long c = insertSort(ar);
			System.out.println(c);
		}
		in.close();
	}

	public static long insertSort(int[] ar) {
		long count = mergeSort(ar, 0, ar.length - 1, new int[ar.length]);
		return count;

	}

	public static long mergeSort(int[] arr, int l, int r, int[] temp) {
		if (l >= r) {
			return 0;
		}

		// partition;
		int m = (l + r) / 2;
		long inversions = 0;

		// sort
		inversions += mergeSort(arr, l, m, temp);
		inversions += mergeSort(arr, m + 1, r, temp);

		// merge
		inversions += merge(arr, l, r, m, temp);
		return inversions;
	}

	public static long merge(int[] array, int leftStart, int rightEnd,
			int middle, int[] temp) {
		long inversions = 0;
		int leftEnd = middle;
		int rightStart = middle + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				inversions += middle - left + 1;
				right++;
			}
			index++;
		}

		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
		return inversions;
	}

}
