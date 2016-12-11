package algorithms.implementation;

import java.util.Scanner;

public class Kangaroo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        
        boolean intersect =  (x1 > x2 && v1 < v2 && (x1-x2)%(v2-v1) == 0) ||
                             (x1 < x2 && v1 > v2 && (x2-x1)%(v1-v2) == 0) ||
                             (x1 == x2 && v1 == v2);    
        
        String result = intersect ? "YES" : "NO";
        System.out.println(result);
        in.close();
    }
}
