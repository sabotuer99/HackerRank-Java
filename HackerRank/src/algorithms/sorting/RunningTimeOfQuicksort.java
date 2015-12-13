package algorithms.sorting;

import java.util.Scanner;

public class RunningTimeOfQuicksort {
    
    public static int iSwaps = 0;
    public static void insertionsort(int[] ar)
    {    
        int shifts = 0;
        int lastIndex = ar.length - 1;
        int var = ar[0];
        for(int i = 1; i < ar.length; i++){       
            for(int j = 0; j < i && ar[i - j - 1] > ar[i - j]; j++){
                int temp = ar[i - j - 1];
                ar[i - j - 1] = ar[i - j];
                ar[i - j] = temp;
                shifts += 1;
            }
        }       
        iSwaps = shifts;
    } 
    
    public static int qSwaps = 0;
    public static void quicksort(int[] A, int lo, int hi){
        if (lo < hi){
            int p = partition(A, lo, hi);
            quicksort(A, lo, p - 1);
            quicksort(A, p + 1, hi);
        }   
    }
    
    public static int partition(int[] A, int lo, int hi){
        int pivot = A[hi];
        int i = lo; //place for swapping
        for (int j = lo; j < hi; j++){
            if (A[j] <= pivot){
                //swap A[i] with A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i = i + 1;
                qSwaps++;
            }
        }
        //swap A[i] with A[hi]
        int temp = A[i];
        A[i] = A[hi];
        A[hi] = temp;
        qSwaps++;
        //printArray(A);        
        return i;        
    }
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] qar = new int[n];
        int[] iar = new int[n];
        for(int i=0;i<n;i++){
            qar[i] = in.nextInt(); 
            iar[i] = qar[i]; 
        } 
        quicksort(qar, 0, n-1);
        insertionsort(iar);
        
        System.out.println(iSwaps - qSwaps);
    }
    
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
