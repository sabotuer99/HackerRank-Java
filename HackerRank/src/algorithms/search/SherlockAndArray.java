package algorithms.search;

import java.util.Scanner;

public class SherlockAndArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            
        for(int t = in.nextInt(); t > 0; t-- ){
            int N = in.nextInt();
            int[] array = new int[N];
            long right = 0;
            for(int i = 0; i < N; i++){
                array[i] = in.nextInt();
                right += array[i];
            }
            
            //System.out.println("right: " + right);
            
            long left = 0;
            if(array.length > 2){  
                
                right -= array[0];
                
                for(int i = 1; left < right; i++){
                    left += array[i-1];
                    right -= array[i];
                    //System.out.println("{" + left + ", " + right + "}");
                }
            }
            
            if(left == right || array.length == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
            
            
            
        }
    }
}
