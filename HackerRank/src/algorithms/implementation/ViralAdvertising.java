package algorithms.implementation;

import java.util.Scanner;

public class ViralAdvertising {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        int adverts = 5;
        
        int total = 0;
        for(int i = 0; i < n; i++){
            int likesToday = adverts/2;
            adverts = likesToday * 3;
            total += likesToday;
        }
        
        System.out.println(total);
    }
}
