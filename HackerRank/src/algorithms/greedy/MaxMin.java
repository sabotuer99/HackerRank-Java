package algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxMin {
	   
	   public static void main(String[] args) throws NumberFormatException, IOException {

	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      int N = Integer.parseInt(in.readLine());
	      int K = Integer.parseInt(in.readLine());
	      int[] list = new int[N];

	      for(int i = 0; i < N; i ++)
	         list[i] = Integer.parseInt(in.readLine());
	      
	      int unfairness = Integer.MAX_VALUE;
	      
	      Arrays.sort(list);
	      
	      for(int i = 0; i < N - K + 1; i++){
	          unfairness = Math.min(unfairness, list[i + K - 1] - list[i]);
	      }      
	      
	      System.out.println(unfairness);
	   }
}
