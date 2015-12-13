package algorithms.search;

import java.util.HashSet;
import java.util.Scanner;

public class Pairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        
        HashSet<Integer> nums = new HashSet<Integer>();
        for(int i = 0; i < N; i++){
            nums.add(new Integer(in.nextInt()));
        }
        
        int count = 0;
        for(Integer key : nums){
            if(nums.contains(key + K))
                count++;
        }
        
        System.out.println(count);
    }
}
