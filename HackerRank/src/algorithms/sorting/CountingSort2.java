package algorithms.sorting;

import java.util.Scanner;

public class CountingSort2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[100];
        for(; N > 0; N--){
            array[in.nextInt()]++;
        }
        
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i]; j++)
                System.out.print(i + " ");
        }
    }
}
