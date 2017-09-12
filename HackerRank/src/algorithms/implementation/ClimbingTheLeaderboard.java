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
        int[] scores = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        in.close();
        
        // calculate existing ranks
        int[] ranks = new int[n];
        ranks[0] = 1;
        for(int i = 1; i < n; i++){
            if(scores[i] < scores[i-1]){
                ranks[i] = ranks[i-1] + 1;
            } else {
                ranks[i] = ranks[i-1];
            }
        }
        
        
        //climb alice up through the ranks
        int index = n - 1;
        for(int score : alice){
            while(scores[index] < score && index > 0){
                index--;
            }
            if(index == 0 && scores[index] < score){
                //alice is the top!
                System.out.println(1);
            } else if(scores[index] == score){
                //alice is tied with the next player, same rank
                System.out.println(ranks[index]);
            } else {
                //alice is one behind the next player
                System.out.println(ranks[index] + 1);
            }
        }
    }
}
