package algorithms.sorting;

import java.util.Scanner;

public class FindTheMedian {
    
    // ADAPTED FROM https://en.wikipedia.org/wiki/Quickselect
    public static int partition(int[] list, int left, int right, int pivotIndex){
        int pivotValue = list[pivotIndex];
        
        //swap list[pivotIndex] and list[right]  
        // Move pivot to end
        swap(list, pivotIndex, right);
        
        int storeIndex = left; 
        
        for (int i = left; i < right; i++){
            if (list[i] <= pivotValue){
                //swap list[storeIndex] and list[i]
                swap(list, i, storeIndex);
                storeIndex += 1;
            }
        }
        
        //swap list[right] and list[storeIndex]  
        // Move pivot to its final place
        swap(list, right, storeIndex);
        
        return storeIndex;        
    }
    
    public static void swap(int[] list, int a, int b){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
    
    // ADAPTED FROM https://en.wikipedia.org/wiki/Quickselect
      // Returns the n-th smallest element of list within left..right inclusive
      // (i.e. left <= n <= right).
      // The search space within the array is changing for each round - but the list
      // is still the same size.Thus, n does not need to be updated with each round.
     public static int select(int[] list, int left, int right, int n){
         if (left == right)        // If the list contains only one element,
             return list[left];  // return that element
         
         int pivotIndex = left + (int)Math.floor(Math.random() * (right - left + 1));     
                        // select a pivotIndex between left and right,
                        // e.g., left + floor(rand() * (right - left + 1))
         pivotIndex = partition(list, left, right, pivotIndex);
         
         if (n == pivotIndex) // The pivot is in its final sorted position
             return list[n];
         else if (n < pivotIndex)
             return select(list, left, pivotIndex - 1, n);
         else
             return select(list, pivotIndex + 1, right, n);
      }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = in.nextInt();
        }
        
        int median = select(array, 0, array.length - 1, n/2 );
        System.out.println(median);
    }
}
