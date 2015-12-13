package algorithms.sorting;

import java.util.Scanner;

public class BiggerIsGreater {
    
    //FROM: http://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    static boolean nextPermutation(char[] array) {
        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(; t > 0; t--){
            char[] word = in.nextLine().toCharArray();
            if(nextPermutation(word)){
                System.out.println(String.valueOf(word));
            } else {
                System.out.println("no answer");
            }
        }
    }
}
