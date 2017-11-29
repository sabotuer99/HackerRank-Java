import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder solution = new StringBuilder(10 * T);
        
        int[] answers = {1,1,2,7,8,4,5,127,128,121,125,97,113,64,65,
                         32767,32768,32761,32765,32737,32753,32641,
                        32705,32257,32513,30721,31745,24577,28673,16384};
        
        
        for(; T > 0; T--){
            int n = in.nextInt();
            if(n%2 == 1)
            {
                solution.append(1).append("\n");
            } else {
                int index = log2(n);
                solution.append(answers[index]).append("\n");
            }
        }
        
        solution.setLength(solution.length() - 1);
        System.out.println(solution);
    }
    
    //https://stackoverflow.com/questions/3305059/how-do-you-calculate-log-base-2-in-java-for-integers
    public static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }
}
