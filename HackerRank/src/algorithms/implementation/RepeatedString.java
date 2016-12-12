package algorithms.implementation;

import java.util.Scanner;

public class RepeatedString {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        
        int acount = 0;
        for(int i = 0; i < s.length(); i++){
            acount += s.charAt(i) == 'a' ? 1 : 0;
        }
        
        long total = n/s.length() * acount;
        
        long leftover = n%s.length();
        for(int i = 0; i < leftover; i++){
            total += s.charAt(i) == 'a' ? 1 : 0;
        }
        
        System.out.println(total);
        in.close();
    }
}
