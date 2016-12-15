package algorithms.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        
        String regex = "([A-Z])";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        
        int count = 1; 
        while(m.find()){
            count++;
        }
        System.out.println(count);  
    }
}
