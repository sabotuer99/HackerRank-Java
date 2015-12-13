package algorithms.implementation;

import java.util.Scanner;

public class ChocolateFeast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long Solve(int N, int C, int M){
        long chocos = N / C;
        long wrappers = chocos;
        while(wrappers >= M){
            long tradein = wrappers / M;
            chocos += tradein;
            wrappers -= tradein * (M - 1);     
        }
        
        return chocos;
    }
}
