package algorithms.dp;

import java.util.Scanner;

public class StockMaximize {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(; t > 0; t--){
            int n = in.nextInt();
            int[] nums = new int[n];
            
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            
            boolean[] buy = new boolean[n];
            buy[n-1] = false;
            
            int max = nums[n-1];
            for(int j = n - 2; j >= 0; j--){
                if(nums[j] < max){
                    buy[j] = true;                    
                } else {
                    buy[j] = false;
                    max = nums[j];
                }
            }
            
            long money = 0;
            long owned = 0;
            for(int i = 0; i < n; i++){
                if(buy[i]){
                    money -= nums[i];
                    owned++;
                } else {
                    money += nums[i] * owned;
                    //System.out.print("Sold " + owned + " on day " + i + " for "+ nums[i] + " each\n");
                    owned = 0;
                }     
            }
            
            
            //System.out.println(Arrays.toString(buy));
            System.out.println(money);
        }
    }
}
