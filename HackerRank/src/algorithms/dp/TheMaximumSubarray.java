package algorithms.dp;

import java.util.Scanner;

public class TheMaximumSubarray {

    /*
    //http://stackoverflow.com/questions/7233042/kadane-algorithm-in-java
    public static int kadane(int[] numbers){
        int max_so_far = 0;
        int max_ending_here = 0;
        for (int i = 0; i < numbers.length;i++){
            max_ending_here = max_ending_here + numbers[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }*/
    
    //adapted from https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane.27s_algorithm
    public static int kadane(int[] A){
        int max_ending_here = A[0];
        int max_so_far = A[0];
        for(int x = 1; x < A.length; x++){
            max_ending_here = Math.max(A[x], max_ending_here + A[x]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(; t > 0; t--){
            int n = in.nextInt();
            int[] numbers = new int[n];
            int possum = 0;
            int highest = Integer.MIN_VALUE;
            boolean hasPos = false;
            
            for(int i = 0; i < n; i++){
                numbers[i] = in.nextInt();
                if(numbers[i] > 0){
                    possum += numbers[i];
                    hasPos = true;
                }
                if(highest < numbers[i])
                    highest = numbers[i];
            }
                
            int bestNonCont = hasPos ? possum : highest;
            System.out.println(kadane(numbers) + " " + bestNonCont);
        }
        
    }
}
