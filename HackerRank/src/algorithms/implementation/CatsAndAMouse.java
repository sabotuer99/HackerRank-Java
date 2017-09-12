package algorithms.implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            
            int distA = Math.abs(x - z);
            int distB = Math.abs(y - z);
            
            String result = "Mouse C";
            if(distA < distB){
                result = "Cat A";
            } else if (distA > distB){
                result = "Cat B";
            }
            
            System.out.println(result);
        }
        in.close();
    }
}
