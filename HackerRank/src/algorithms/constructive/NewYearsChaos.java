package algorithms.constructive;

import java.util.Scanner;

public class NewYearsChaos {
    public static int insertionSort(int[] q){
        int inversions = 0;
        for(int i = 0; i < q.length; i++){
            if(q[i]-i-1 > 2){ return -1; };
            if(i > 0 && q[i] < q[i-1]){                
                for(int j = i; j > 0 && q[j] < q[j-1]; j--){
                    int temp = q[j-1];
                    q[j-1] = q[j];
                    q[j] = temp;           
                    inversions++;
                }
            }
        }
        
        return inversions;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n];
            for(int q_i=0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            int bribes = insertionSort(q);
            
            if(bribes == -1){
                System.out.println("Too chaotic");
            } else {
                System.out.println(bribes);
            }
        }
        in.close();
    }
}
