package algorithms.implementation;

import java.util.Scanner;

public class AngryProfessor {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(; t > 0; t--){
            int N = in.nextInt();
            int K = in.nextInt();
            for(; N > 0; N--){
                if(in.nextInt() <= 0)
                    K -= 1;
                if (K == 0){
                    in.nextLine();
                    break;
                }
                    
            }
            if(K > 0)
                System.out.println("YES");
            else
                System.out.println("NO");
                
        }        
    }
}
