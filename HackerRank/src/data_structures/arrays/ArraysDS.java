package data_structures.arrays;

import java.util.Scanner;

public class ArraysDS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = in.nextInt();
        }
        
        for(int i = array.length - 1; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
    }
}
