package algorithms.sorting;

import java.util.Scanner;

public class TheFullCountingSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[100];
        int[] pos = new int[100];
        String[] strings = new String[N];
        String[] sorted = new String[N];
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = in.nextInt();
            
            if(i < N / 2){
                strings[i] = "-";
                in.nextLine();
            } else {
                strings[i] = in.nextLine().trim();
            }
                
            array[nums[i]]++;
        }
        
        //last element is always N
        pos[99] = N;
        
        for(int j = 98; j >= 0; j--){
            pos[j] = pos[j + 1] - array[j + 1];
        }

        //Sort the strings
        for(int i = 0; i < N; i++){
            int index = pos[nums[i]] - array[nums[i]];
            sorted[index] = strings[i];
            pos[nums[i]] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(sorted[i] + " ");
        }
        
        System.out.println(sb.toString());
    }
}
