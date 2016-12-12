package algorithms.implementation;

import java.util.Scanner;

public class JumpingClouds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        int jumps = 0;
        for(int i = 0; i < n-1; jumps++){
            if(i + 2 >=n || c[i+2] == 1){
                i++;
            } else {
                i += 2;
            }
        }
        
        System.out.println(jumps);
        in.close();
    }
}
