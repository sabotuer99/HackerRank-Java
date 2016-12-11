package algorithms.implementation;

import java.util.Scanner;

public class SockMerchant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int c[] = new int[n];
        int[] socks = new int[101];
        
        for(int c_i=0; c_i < n; c_i++){
            int sock = in.nextInt();
            socks[sock]++;
        }
        
        int pairs = 0;
        for(int count : socks){
            pairs += count / 2;
        }
        
        System.out.println(pairs);
        in.close();
    }
}
