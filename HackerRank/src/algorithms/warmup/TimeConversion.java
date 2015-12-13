package algorithms.warmup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        
        try{
        String string = in.nextLine();
        DateFormat inFormat = new SimpleDateFormat("hh:mm:ssaa", Locale.ENGLISH);
        Date date = inFormat.parse(string);
        
        DateFormat outFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        String reformated = outFormat.format(date);
        
        System.out.println(reformated);
        }
        catch (Exception ex){
            
        }
    }
}
