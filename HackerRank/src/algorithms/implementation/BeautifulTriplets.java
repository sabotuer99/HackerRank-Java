package algorithms.implementation;

import java.util.Scanner;

public class BeautifulTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] arr = new int[n];
        int[] diffs = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        
        int matches = 0;
        for(int i = 0; i < n-2; i++){
            boolean found = false;
            for(int j = i+1; j < n-1; j++){
                if(arr[j] - arr[i] == d){
                    for(int k = j+1; k < n; k++){
                        if(arr[k] - arr[j] == d){
                            matches++;
                            found = true;
                            break;
                        }
                    }
                    if(found){
                        break;
                    }
                }
            }
        }
        
        System.out.println(matches);
        in.close();
    }
}
