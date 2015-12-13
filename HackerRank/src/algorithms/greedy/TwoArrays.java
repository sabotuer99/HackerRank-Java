package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class TwoArrays {
	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(; t > 0; t--){
	            int N = in.nextInt();
	            int K = in.nextInt();
	            int[] A = new int[N];
	            int[] B = new int[N];
	            
	            for(int i = 0; i < N; i++)
	                A[i] = in.nextInt();
	            
	            for(int i = 0; i < N; i++)
	                B[i] = in.nextInt();
	            
	            Arrays.sort(A);
	            Arrays.sort(B);
	            
	            boolean permExists = true;
	            for(int i = 0; i < N/2; i++){
	                if(A[i] + B[N - 1 - i] < K){
	                    permExists = false;
	                    break;
	                }
	            }
	            
	            String result = permExists ? "YES" : "NO"; 
	            System.out.println(result);
	        }
	            
	    }
}
