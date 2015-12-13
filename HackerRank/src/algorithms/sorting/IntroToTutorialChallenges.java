package algorithms.sorting;

import java.util.Scanner;

public class IntroToTutorialChallenges {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V, N;
        V = in.nextInt();
        N = in.nextInt();
        
        for (int i=0;i<N;i++) {
            int a = in.nextInt();
            if(a == V){
                System.out.println(i);
                break;
            }               
        }       
    }
}
