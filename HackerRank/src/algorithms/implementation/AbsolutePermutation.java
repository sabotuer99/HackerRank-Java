package algorithms.implementation;

import java.util.Scanner;

public class AbsolutePermutation {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] result = new int[n+1];
            StringBuilder sb = new StringBuilder();
            
            boolean add = true;
            for(int i = 1; i <= n; i++){ 
                int num = add ? i + k : i - k;
                if(k > 0 && i%k == 0){
                    add = !add;
                }
                if(num <= n && num > 0){
                    result[num]++;
                }
                sb.append(num).append(" ");
            }
            
            boolean legal = true;
            for(int i = 1; i <= n; i++){
                legal = result[i] == 1 && legal;
            }
            if(legal){
                System.out.println(sb.toString().trim());
            } else {
                System.out.println(-1);
            }
            
        }
        in.close();
    }
}
