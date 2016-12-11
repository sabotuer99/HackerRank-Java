package algorithms.implementation;

import java.util.Scanner;

public class AppleOrange {
	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int houseLeft = in.nextInt();
	        int houseRight = in.nextInt();
	        int appleTree = in.nextInt();
	        int orangeTree = in.nextInt();
	        int apples = in.nextInt();
	        int oranges = in.nextInt();
	        
	        int applesOnHouse = 0;
	        int orangesOnHouse = 0;
	        
	        for(int apple_i=0; apple_i < apples; apple_i++){
	            int dist = in.nextInt();
	            int loc = appleTree + dist;
	            if(loc >= houseLeft && loc <= houseRight){
	                applesOnHouse++;   
	            }
	        }
	        
	        for(int orange_i=0; orange_i < oranges; orange_i++){
	            int dist = in.nextInt();
	            int loc = orangeTree + dist;
	            if(loc >= houseLeft && loc <= houseRight){
	                orangesOnHouse++;   
	            }
	        }
	        
	        System.out.println(applesOnHouse);
	        System.out.println(orangesOnHouse);
	        
	        in.close();
	        
	        
	    }
}
