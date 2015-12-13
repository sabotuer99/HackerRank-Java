package algorithms.strings;

import java.util.Scanner;

public class FunnyString {

    public static void main(String[] args) {

    	Scanner in = new Scanner(System.in);
        int t;
        t = in.nextInt();
        String[] lines = new String[t];
        in.nextLine();
        
        for (int i=0;i<t;i++) {
            String string = in.nextLine();
            System.out.println(isFunny(string));
        }

    }
    
    public static String isFunny(String str){
        for(int i = 0; i < str.length()/2 ; i++){
            int a, b, c, d;
            a = (int)str.charAt(i);
            b = (int)str.charAt(i + 1);
            d = (int)str.charAt(str.length() - 1 - i);
            c = (int)str.charAt(str.length() - 2 - i);
            if(Math.abs(a-b) != Math.abs(d-c))
                return "Not Funny";
        }
        return "Funny";
    }
}
