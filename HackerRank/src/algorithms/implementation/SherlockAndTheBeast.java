package algorithms.implementation;

import java.util.Scanner;

public class SherlockAndTheBeast {
	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        
	        for(; t > 0; t--){
	            int N = in.nextInt();
	            String result;
	            StringBuilder sb = new StringBuilder();
	            
	            int remain = N % 3;
	            remain = remain > 0 ? 3 - remain : 0;
	            
	            if(N >= (remain * 5)){
	                for(int i = 0; i < (N -(remain * 5))/3; i++)
	                    sb.append("555");
	                for(int j = 0; j < remain; j++)
	                    sb.append("33333");
	                result = sb.toString();
	            } else {
	                result = "-1";
	            }
	            
	            System.out.println(result);
	            
	        }
	        
	    }
}
