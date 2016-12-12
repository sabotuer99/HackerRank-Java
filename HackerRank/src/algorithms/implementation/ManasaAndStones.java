package algorithms.implementation;

import java.util.Scanner;

public class ManasaAndStones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(;T > 0; T--){
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            
            if(a < b){
                int temp = a;
                a = b;
                b = temp;
            }
            
            StringBuilder sb = new StringBuilder();
            int last = 0;
            for(int i = 0; i < n; i++){
                int next = a * i + (n-1-i) * b;
                if(next != last){
                    sb.append(next).append(" ");
                }
                last = next;
            }
            System.out.println(sb.toString().trim());
        }
        
        in.close();
    }
}
