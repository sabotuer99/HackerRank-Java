package algorithms.implementation;

import java.util.Scanner;

public class SaveThePrisoner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T > 0; T--){
            long N = in.nextLong();
            long M = in.nextLong();
            long S = in.nextLong();
            
            long pris = (S - 1 + M)%N;
            pris = pris == 0 ? N : pris;
            
            System.out.println(pris);
                
        }
        in.close();
    }
}
