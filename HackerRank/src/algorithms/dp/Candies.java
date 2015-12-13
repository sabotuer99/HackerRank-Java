package algorithms.dp;

import java.util.Scanner;

public class Candies {

    public static int DP(int[] ratings, int[] results, int index){
        //memoization
        if(results[index] != 0 || index == 0 || index == ratings.length - 1)
            return results[index];
        
        //base case
        if(ratings[index] <= ratings[index - 1] && ratings[index] <= ratings[index + 1]){
            results[index] = 1;
            return 1;
        }
        
        //peak
        if(ratings[index] > ratings[index - 1] && ratings[index] > ratings[index + 1]){
            int result = Math.max(DP(ratings, results, index - 1), DP(ratings, results, index + 1)) + 1;
            results[index] = result;
            return result;
        }

        //upward slope
        if(ratings[index] > ratings[index - 1] && ratings[index] <= ratings[index + 1]){
            int result = DP(ratings, results, index - 1) + 1;
            results[index] = result;
            return result;
        }
        
        //downward slope
        if(ratings[index] <= ratings[index - 1] && ratings[index] > ratings[index + 1]){
            int result = DP(ratings, results, index + 1) + 1;
            results[index] = result;
            return result;
        }

        System.out.println("Fell through DP... oops");
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] ratings = new int[n + 2];
        int[] results = new int[n + 2];
        for(int i = 1; i <= n; i++){
            ratings[i] = in.nextInt();
        }
        
        for(int i = 1; i <= n; i++){
            DP(ratings, results, i);
        }
        
        int total = 0;
        for(int i = 1; i <= n; i++){
            total += results[i];
        }
        //System.out.println(Arrays.toString(ratings));
        //System.out.println(Arrays.toString(results));
        System.out.println(total);
    }
}
