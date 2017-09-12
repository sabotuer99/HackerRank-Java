package algorithms.implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] steps = in.next().toCharArray();
        in.close();
        
        int elevation = 0; 
        int valleys = 0;
        
        for(char step : steps){
            elevation += step == 'U' ? 1 : -1;
            if(elevation == 0 && step == 'U'){
                valleys += 1;    
            }
        }
        
        System.out.println(valleys);
        
    }
}
