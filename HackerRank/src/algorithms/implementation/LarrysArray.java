package algorithms.implementation;

import java.util.Scanner;

public class LarrysArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T > 0; T--){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            
            //brute force it
            for(int j = 0; j < n-2; j++){
                for(int i = 0; i < n-2; i++){
                    //boolean rot0ok = arr[i] < arr[i+1] && arr[i+1] < arr[i+2];
                    boolean rot1ok = arr[i] < arr[i+1] && arr[i+1] > arr[i+2];
                    boolean rot2ok = arr[i] > arr[i+1] && arr[i+1] < arr[i+2];
                 
                    if(rot1ok){
                        int temp[] = new int[3];
                        temp[0] = arr[i+2];
                        temp[1] = arr[i];
                        temp[2] = arr[i+1];
                        System.arraycopy(temp, 0, arr, i, 3);    
                    } else if(rot2ok){
                        int temp[] = new int[3];
                        temp[0] = arr[i+1];
                        temp[1] = arr[i+2];
                        temp[2] = arr[i];
                        System.arraycopy(temp, 0, arr, i, 3);  
                    } 
                }
                //System.out.println(Arrays.toString(arr));
            }
            
            //check sorted
            boolean sorted = true;
            for(int i = 0; i < n-1 && sorted; i++){
                sorted = sorted && arr[i] < arr[i+1];
            }

            System.out.println(sorted ? "YES" : "NO");
        }
        in.close();
    }                    
}
