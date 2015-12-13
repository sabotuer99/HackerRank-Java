package algorithms.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        List<Integer> sticks = new ArrayList<Integer>();
        for(int t = in.nextInt(); t > 0; t--){
            sticks.add(new Integer(in.nextInt()));
        }
        
        Collections.sort(sticks);
        
        int smallest = 0;
        
        for(int i = 0; i < sticks.size(); i++){
            int stick = sticks.get(i);
            if(stick > smallest){
                smallest = stick;
                System.out.println(sticks.size() - i);
            }
        }
    }
}
