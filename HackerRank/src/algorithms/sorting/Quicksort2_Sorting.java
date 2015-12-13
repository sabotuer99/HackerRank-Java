package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quicksort2_Sorting {

	static void quickSort(Integer[] ar) {
		if (ar.length < 2)
			return;

		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		int p = ar[0];
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] < p)
				left.add(ar[i]);
			else
				right.add(ar[i]);
		}

		Integer[] lar = left.toArray(new Integer[left.size()]);
		Integer[] rar = right.toArray(new Integer[right.size()]);
		quickSort(lar);
		quickSort(rar);

		for (int i = 0; i < ar.length; i++) {
			if (i < lar.length)
				ar[i] = lar[i];
			else if (i == lar.length)
				ar[i] = p;
			else
				ar[i] = rar[i - lar.length - 1];
		}

		printArray(ar);
	}

	static void printArray(Integer[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] ar = new Integer[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		quickSort(ar);
	}
}
