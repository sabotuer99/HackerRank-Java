package algorithms.implementation;

import java.util.Scanner;

public class BeautifulDaysMovies {
    public static int reverse(int num){
        StringBuilder sb = new StringBuilder();
        String reversed = sb.append(num).reverse().toString();
        return Integer.parseInt(reversed);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = in.nextInt();
        int end = in.nextInt();
        int k = in.nextInt();
        in.close();
        
        int beautiful = 0;
        for(int i = start; i <= end; i++){
            int reversed = reverse(i);
            if(Math.abs(i - reversed)%k == 0){
                beautiful++;
            }
        }
        
        System.out.println(beautiful);
        
    }
}
