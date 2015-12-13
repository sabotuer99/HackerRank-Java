package algorithms.dp;

import java.util.Scanner;

public class RedJohnIsBack {

	// http://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
	public static int smallerPrimes(int N) {
		// initially assume all integers are prime
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i <= N; i++) {

			// if i is prime, then mark multiples of i as nonprime
			// suffices to consider mutiples i, i+1, ..., N/i
			if (isPrime[i]) {
				for (int j = i; i * j <= N; j++) {
					isPrime[i * j] = false;
				}
			}
		}

		// count primes
		int primes = 0;
		for (int i = 2; i <= N; i++) {
			if (isPrime[i])
				primes++;
		}

		return primes;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (; t > 0; t--) {

			int N = in.nextInt();
			int[] DP = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				if (i < 4)
					DP[i] = 1;
				else if (i == 4)
					DP[i] = 2;
				else
					DP[i] = DP[i - 1] + DP[i - 4];
			}

			int M = DP[N];
			System.out.println(smallerPrimes(M));
		}
	}
}
