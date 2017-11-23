import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0; 
        int[] buildings = new int[n];
        
        for(int i = 0; i < n; i++){
            buildings[i] = in.nextInt();
        }
        
        int min = 1;
        int max = 100000;
        int guess = (min + max)/2;
        
        while(min < max){
            int e = getFinalEnergy(buildings, guess);
            //System.out.println(e + " " + min + " " + max + " " + guess);
            
            
            if(e > 0){
                max = guess;
            } else if (e < 0) {
                min = guess + 1; 
            } else {
                break;
            }
            
            
            guess = (min + max)/2;
        }
        
        

        System.out.println(guess);
    }
    
    static int getFinalEnergy(int[] buildings, int e){
        for(int b : buildings){
            //System.out.println(e + "|" + b);
            e += e - b;
            
            if(e > 100000 || e < 0){
                return e;
            }
        }
        
        return e;
    }
    
}
