package algorithms.sorting;

import java.util.Scanner;

public class InsertionSort_Part2 {

    public static void insertionSortPart2(int[] ar)
    {       
        int lastIndex = ar.length - 1;
        int var = ar[0];
        for(int i = 1; i < ar.length; i++){
               
            for(int j = 0; j < i && ar[i - j - 1] > ar[i - j]; j++){
                int temp = ar[i - j - 1];
                ar[i - j - 1] = ar[i - j];
                ar[i - j] = temp;
            }
            
            printArray(ar);
        }
    }  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
