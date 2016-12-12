package algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifiedKaprekar {
	   
    public static boolean isKaprekar(long number){
        int d = Long.toString(number).length();
        String sqrStr = Long.toString(number * number);
        if(sqrStr.length() == d){
            return number == number * number;
        } else {
            d -= sqrStr.length() % 2;
            String left = sqrStr.substring(0,d);
            String right = sqrStr.substring(d);
            long total = Long.parseLong(left) + Long.parseLong(right);
            return total == number;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long min = in.nextLong();
        long max = in.nextLong();
        
        List<Long> kaps = new ArrayList<>();
        for(long i = min; i <= max; i++){
            if(isKaprekar(i)){
                kaps.add(i);
            }
        }
        
        if(kaps.size() == 0){
            System.out.println("INVALID RANGE");
        } else {
            StringBuilder sb = new StringBuilder();
            for(Long num : kaps){
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        in.close();
    }
}
