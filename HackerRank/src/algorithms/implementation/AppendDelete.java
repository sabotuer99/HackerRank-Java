package algorithms.implementation;

import java.util.Scanner;

public class AppendDelete {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        in.close();
        
        
        if(s.length() + t.length() <= k){
            System.out.println("Yes");
            return;
        }
        
        int i = 0;
        for(; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){
                break;
            }
        }
        
        int sremain = s.length() - i;
        int tremain = t.length() - i;
        int combined = sremain + tremain;
        
        if(combined > k){
            System.out.println("No");
        } else {
            if(combined % 2 == k % 2){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        
    }
}
