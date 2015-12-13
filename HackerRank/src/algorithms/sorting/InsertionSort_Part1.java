package algorithms.sorting;

import java.util.Scanner;

public class InsertionSort_Part1 {
    public static void insertIntoSorted(int[] ar) {
        int lastIndex = ar.length - 1;
        int var = ar[lastIndex];
        for(int i = lastIndex; i >= 0; i--){
            if(i == 0){
                ar[0] = var;
            }                
            else {
                if(var > ar[i - 1]){
                    ar[i] = var;
                    printArray(ar);
                    break;
                }                 
                else
                    ar[i] = ar[i - 1];
            }
            
            printArray(ar);
        }
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
