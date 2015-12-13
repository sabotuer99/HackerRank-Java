package algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> nums = new ArrayList<Integer>();
        List<Integer> mins = new ArrayList<Integer>();
        for(; N > 0; N--){
            nums.add(in.nextInt());
        }
        Collections.sort(nums);
        
        int mindiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.size() - 1; i++){
            int diff = nums.get(i + 1) - nums.get(i) ;
            if( diff < mindiff){
                mindiff = diff;
                mins = new ArrayList<Integer>();
                mins.add(nums.get(i));
                mins.add(nums.get(i + 1));
            } else if (diff == mindiff){
                mins.add(nums.get(i));
                mins.add(nums.get(i + 1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mins.size(); i++){
            sb.append(mins.get(i) + " ");
        }
        
        System.out.println(sb.toString());
    }
}
