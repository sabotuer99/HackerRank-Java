package algorithms.strings;

import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndValidString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] alphaCount = new int[26];
        char[] input = in.nextLine().toCharArray();
        
        for(char letter : input){
            alphaCount[letter - 'a']++;
        }
        
        HashMap<Integer, Integer> distinctCounts = new HashMap<Integer, Integer>();
        for(int count : alphaCount){
            if(count == 0)
                continue;
            Integer key = new Integer(count);
            Integer saved = distinctCounts.get(key);
            saved = saved == null ? 1 : saved + 1;
            distinctCounts.put(key, saved);
        }
        
        //More than two counts requires too many removals
        if(distinctCounts.size() > 2){
            System.out.println("NO");
            return;
        }
        
        //All same counts, nothing to do
        if(distinctCounts.size() == 1){
            System.out.println("YES");
            return;
        }
        
        int index = 0;
        Integer[] keys = new Integer[2];
        for(Integer key : distinctCounts.keySet()){
            keys[index] = key;
            index++;
        }
        
        //if either is one, and count is one, we can just drop it entirely
        if((keys[0] == 1 && distinctCounts.get(keys[0]) == 1) ||
           (keys[1] == 1 && distinctCounts.get(keys[1]) == 1)){
            System.out.println("YES");
            return;           
        }
        
        //if the counts are one apart, and one count only occurs once, answer is "YES" otherwise "NO"
        if(Math.abs(keys[0] - keys[1]) > 1 || 
           (distinctCounts.get(keys[0]) > 1 && 
            distinctCounts.get(keys[1]) > 1)){
            System.out.println("NO");
            return;
        } else {
            System.out.println("YES");
            return;   
        }

    }
}
