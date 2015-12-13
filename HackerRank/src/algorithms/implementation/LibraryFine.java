package algorithms.implementation;

import java.util.Scanner;

public class LibraryFine {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int actDay = in.nextInt();
        int actMon = in.nextInt();
        int actYr  = in.nextInt();
        
        int expDay = in.nextInt();
        int expMon = in.nextInt();
        int expYr  = in.nextInt();
        
        if(actYr > expYr){
            System.out.println(10000);
            return;
        } else if (actYr < expYr){
            System.out.println(0);
            return;
        }
        
        if(actMon > expMon){
            System.out.println(500 * (actMon - expMon));
            return;
        } else if (actMon < expMon){
            System.out.println(0);
            return;
        }
        
        if(actDay > expDay){
            System.out.println(15 * (actDay - expDay));
        } else {
            System.out.println(0);
        }
        
    }
}
