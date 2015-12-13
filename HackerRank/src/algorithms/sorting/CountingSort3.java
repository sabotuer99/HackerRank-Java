package algorithms.sorting;

import java.util.Scanner;

public class CountingSort3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[100];
        int[] pos = new int[100];
        for(int i = 0; i < N; i++){
            array[in.nextInt()]++;
            in.nextLine();
        }
        
        //last element is always N
        pos[99] = N;
        
        for(int j = 98; j >= 0; j--){
            pos[j] = pos[j + 1] - array[j + 1];
        }

        for(int i = 0; i < pos.length; i++){
            System.out.print(pos[i] + " ");
        }
    }
}
