package algorithms.bitmanipulation;

import java.util.Scanner;

public class TwosComplement {

	// http://stackoverflow.com/questions/109023/how-to-count-the-number-of-set-bits-in-a-32-bit-integer
	public static int NumberOfSetBits(int i) {
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		return (((i + (i >>> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;
	}

	// http://stackoverflow.com/questions/3305059/how-do-you-calculate-log-base-2-in-java-for-integers
	public static int binlog(int bits) // returns 0 for bits=0
	{
		int log = 0;
		if ((bits & 0xffff0000) != 0) {
			bits >>>= 16;
			log = 16;
		}
		if (bits >= 256) {
			bits >>>= 8;
			log += 8;
		}
		if (bits >= 16) {
			bits >>>= 4;
			log += 4;
		}
		if (bits >= 4) {
			bits >>>= 2;
			log += 2;
		}
		return log + (bits >>> 1);
	}

	public static long[] twos = new long[32];
	public static long[] gaps = new long[31];

	public static void calc() {
		twos[0] = 0;
		for (int i = 1; i < twos.length; i++) {
			twos[i] = twos[i - 1] * 2 + (int) Math.pow(2, i - 1);
			gaps[i - 1] = twos[i] - twos[i - 1];
		}

		// System.out.println(Arrays.toString(twos));
		// System.out.println(Arrays.toString(gaps));
	}

	public static long countNeg(int x) {

		if (x == Integer.MIN_VALUE)
			return 35433480192L;

		int inv = Integer.MAX_VALUE + x;
		return twos[31] - countOnes(inv) - x;
	}

	public static long countOnes(int x) {
		if (x < 0)
			return countNeg(x);

		if (x == Integer.MAX_VALUE)
			return 33285996544L;

		long sum = 0;
		int log = binlog(x + 1);
		int pow = (int) Math.pow(2, log) - 1;

		sum += twos[log];
		int remain = x - pow;
		for (int i = 0; remain > 0; i++) {
			// System.out.print(remain + " ");
			int nextLog = binlog(remain);
			long add = gaps[nextLog];
			add += (int) Math.pow(2, nextLog) * i;

			// System.out.println("Adding: " + add);
			sum += add;
			remain -= (int) Math.pow(2, nextLog);
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		calc();

		/*
		 * int n1 = NumberOfSetBits(-1); int n2 = NumberOfSetBits(-2) + n1; int
		 * n3 = NumberOfSetBits(-3) + n2;
		 * 
		 * System.out.println("Bits in MIN: " +
		 * NumberOfSetBits(Integer.MIN_VALUE));
		 * System.out.println("Bits in MAX: " +
		 * NumberOfSetBits(Integer.MAX_VALUE));
		 * 
		 * System.out.println("-1 BF: "+ n1 + " CN: " + countNeg(-1));
		 * System.out.println("-2 BF: "+ n2 + " CN: " + countNeg(-2));
		 * System.out.println("-3 BF: "+ n3 + " CN: " + countNeg(-3));
		 * 
		 * //testing for(int i = -16; i <= 0; i++){
		 * System.out.print(NumberOfSetBits(i) + " "); } System.out.println();
		 * 
		 * 
		 * for(int i = Integer.MIN_VALUE - 16; i >= 0; i++){
		 * System.out.print((NumberOfSetBits(i)+1) + " "); }
		 * System.out.println(); //ending //
		 */

		while (in.hasNext()) {
			int A = in.nextInt();
			int B = in.nextInt();

			long sum = 0;

			if (A < 0 && B > 0) { // if they have opposite signs, add together
				sum = countOnes(A) + countOnes(B);
			} else if (A < 0) {
				B = B == 0 ? B : B + 1;
				sum = Math.abs(countOnes(A) - countOnes(B));
			} else {
				A = A == 0 ? A : A - 1;
				sum = Math.abs(countOnes(B) - countOnes(A));
			}

			System.out.println(sum);

			// System.out.println(twos[31] + " " + countOnes(Integer.MAX_VALUE -
			// 1));
			// 33285996544
		}
	}
}
