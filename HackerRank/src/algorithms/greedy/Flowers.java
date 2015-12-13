package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Flowers {
	   public static void main( String args[] ){
		      Scanner in = new Scanner(System.in);
		      
		      int N, K;
		      N = in.nextInt();
		      K = in.nextInt();
		      
		      int[] C = new int[N];
		      for(int i=0; i<N; i++){
		         C[i] = in.nextInt();
		      }
		       
		      Arrays.sort(C);
		      int total = 0;
		      for(int i = 0; i < N; i++){
		          int j = N - 1 - i;
		          int round = i/K;
		          total += (round + 1) * C[j];
		      }
		       
		      System.out.println(total);

		   }
}
