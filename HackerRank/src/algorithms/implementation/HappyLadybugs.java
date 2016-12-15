package algorithms.implementation;

import java.util.Scanner;

public class HappyLadybugs {

    public static boolean isHappy(char[] bugs, int i){
        char bug = bugs[i];
        
        if(bug == '_'){
            return true;
        }
        char left = i == 0 ? '_' : bugs[i-1];
        char right = i == bugs.length - 1 ? '_' : bugs[i+1];
        
        return bug == left || bug == right;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T > 0; T--){
            int n = in.nextInt();
            char[] bugs = in.next().toCharArray();
            
            int[] bugCount = new int[26];
            int blankCount = 0;
            
            
            boolean happy = true;       
            
            for(int i = 0; i < n; i++){
                //check if initial config is already happy
                happy = happy && isHappy(bugs, i);
                char bug = bugs[i];
                if(bug != '_'){
                    bugCount[bug - 'A']++;
                } else {
                    blankCount++;
                }
            }
            
            int minBug = Integer.MAX_VALUE;
            for(int count : bugCount){
                if(count > 0){
                    minBug = Math.min(minBug, count);
                }
            }
            
            if(happy || (minBug > 1 && blankCount > 0)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
        }
        in.close();
    }
}
