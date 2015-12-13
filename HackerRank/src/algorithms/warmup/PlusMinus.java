package algorithms.warmup;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        double pos = 0, neg = 0, zero = 0;
        int N = in.nextInt();
        for(int i = 0; i < N; i++){
            int next = in.nextInt();
            if(next < 0)
                neg++;
            else if(next > 0)
                pos++;
            else 
                zero++;
        }
        
        DecimalFormat df = new DecimalFormat("0.000");
        
        System.out.println(df.format(pos/N));
        System.out.println(df.format(neg/N));
        System.out.println(df.format(zero/N));
    }
    
    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
