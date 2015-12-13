package algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcmIcpcTeam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int players = in.nextInt();
        int subjects = in.nextInt();
        int max = 0;
        int count = 0;
        List<char[]> matrix = new ArrayList<char[]>();
        in.nextLine();
        for(; players > 0; players--){
            char[] skillset = in.nextLine().toCharArray();
            if(matrix.size() > 0){
                for(char[] arr : matrix){
                    int joint = 0;
                    for(int i = 0; i < arr.length; i++){
                        joint += (arr[i] - '0') | (skillset[i] - '0');
                    }
                    if(joint > max){
                        max = joint;
                        count = 1;
                    } else if(joint == max){
                        //System.out.println("Size " + max + ":" + Arrays.toString(skillset) + "&" 
                        //                   + Arrays.toString(arr) + " count: " + count);
                        count += 1;
                    }                   
                }
            } else {
                int joint = 0;
                    for(int i = 0; i < skillset.length; i++){
                        joint += (skillset[i] - '0');
                    }
                    if(joint > max){
                        max = joint;
                        count = 1;
                    }            
                    if(joint == max){
                        count += 1;
                    } 
            }         
            matrix.add(skillset);
        }
        System.out.println(max);
        System.out.println(count);
    }
}
