package algorithms.sorting;

import java.util.Scanner;

public class QuicksortInPlace {
	/*
	quicksort(A, lo, hi)
	  if lo < hi
	    p = partition(A, lo, hi)
	    quicksort(A, lo, p - 1)
	    quicksort(A, p + 1, hi)

	partition(A, lo, hi)
	    pivot = A[hi]
	    i = lo #place for swapping
	    for j = lo to hi - 1
	        if A[j] <= pivot
	            swap A[i] with A[j]
	            i = i + 1
	    swap A[i] with A[hi]
	    return i
	*/    
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
	            }
	        }
	        //swap A[i] with A[hi]
	        int temp = A[i];
	        A[i] = A[hi];
	        A[hi] = temp;
	        
	        printArray(A);
	        
	        return i;        
	    }
	        
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] ar = new int[n];
	        for(int i=0;i<n;i++){
	            ar[i]=in.nextInt(); 
	        } 
	        quicksort(ar, 0, n-1);
	    }
	    
	    static void printArray(int[] ar) {
	        for(int n: ar){
	            System.out.print(n+" ");
	        }
	        System.out.println("");
	    }
}
