package algorithms.implementation;

import java.util.Scanner;

public class BonAppetit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int total = 0;
        int fairTotal = 0;
        int omitted = 0;
        for(int i = 0; i < n; i++){
            int value = in.nextInt();
            if(i != k){
                fairTotal += value;
            } else {
                omitted = value;
            }
            total += value;
        }
        
        int charged = in.nextInt();
        if(charged == fairTotal / 2){
            System.out.println("Bon Appetit");
        } else {
            System.out.println(omitted / 2);
        }
        in.close();
    }
}
