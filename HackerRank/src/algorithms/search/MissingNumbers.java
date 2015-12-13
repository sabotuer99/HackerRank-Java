package algorithms.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> found = new HashMap<Integer, Integer>();
        Set<Integer> missing = new TreeSet<Integer>();
        
        int Bn = in.nextInt();
        for(int i = 0; i < Bn; i++){
            int num = in.nextInt();
            Integer count = found.get(num);
            count = count == null ? 1 : count + 1;
            found.put(num, count);
        }
        
        int An = in.nextInt();
        for(int i = 0; i < An; i++){
            int num = in.nextInt();
            Integer count = found.get(num);
            if(count == 0)
                missing.add(num);
            else
                found.put(num, count - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(Integer num : missing){
            sb.append(num + " ");
        }
        
        System.out.println(sb.toString());
    }
}
