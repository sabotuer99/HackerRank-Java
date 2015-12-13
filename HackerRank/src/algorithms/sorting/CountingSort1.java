package algorithms.sorting;

import java.util.Scanner;

public class CountingSort1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[100];
        for(; N > 0; N--){
            array[in.nextInt()]++;
        }
        
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
