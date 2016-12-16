package algorithms.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumPerimeterTriangle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] sides = new Integer[n];
        for(int i = 0; i < n; i++){
            sides[i] = in.nextInt();
        }
        in.close();
        Arrays.sort(sides, Collections.reverseOrder());
        for(int i = 0; i < n-2; i++){
            if(sides[i] < sides[i+1] + sides[i+2]){
                System.out.printf("%d %d %d\n", sides[i+2], sides[i+1], sides[i]);
                return;
            }
        }
        System.out.println(-1);
    }
}
