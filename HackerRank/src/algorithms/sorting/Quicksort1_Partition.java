package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quicksort1_Partition {
    
 static void partition(int[] ar) {
     List<Integer> left = new ArrayList<Integer>();
     List<Integer> right = new ArrayList<Integer>();
     int p = ar[0];
     for(int i = 1; i < ar.length; i++){
         if(ar[i] < p)
             left.add(ar[i]);
         else
             right.add(ar[i]);
     }
     left.add(p);
     left.addAll(right);
     
     printArray(left.toArray(new Integer[ar.length]));
 }   

 static void printArray(Integer[] ar) {
     for(int n: ar){
         System.out.print(n+" ");
     }
     System.out.println("");
 }

 public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     int[] ar = new int[n];
     for(int i=0;i<n;i++){
         ar[i]=in.nextInt(); 
     }
     partition(ar);
 } 
}
