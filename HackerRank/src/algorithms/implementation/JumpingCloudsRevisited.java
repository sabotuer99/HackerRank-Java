package algorithms.implementation;

import java.util.Scanner;

public class JumpingCloudsRevisited {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        in.close();
        
        int energy = 100;
        int index = 0;
        do{
            energy--;
            index = (index + k)%n;
            if(c[index] == 1){
                energy -= 2;
            }
        } while (index != 0);
        
        System.out.println(energy);
    }
}
